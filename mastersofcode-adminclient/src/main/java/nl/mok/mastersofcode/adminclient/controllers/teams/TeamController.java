package nl.mok.mastersofcode.adminclient.controllers.teams;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Member;
import remote.ws.mok.domain.User;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/teams")
public class TeamController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showUsers(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("teams", getFakeUsers());

        mav.addObject("page", new Object() {
            public String uri = "/mok/teams";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("teams/teams.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public ModelAndView showUser(final HttpServletRequest request,
            @PathVariable String username) {
        ModelAndView mav = new ModelAndView();

        User team = new User();
        team.setUsername(username);
        team.setUsername("De JavaDokters");
        mav.addObject("team", team);
        mav.addObject("members", getFakeMembers());

        mav.addObject("page", new Object() {
            public String uri = "/mok/team";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("teams/team.twig");

        return mav;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{username}/addmember")
    public ModelAndView showAddMember(final HttpServletRequest request,
            @PathVariable String username) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("username", username);
        mav.addObject("members", getFakeMembers());

        mav.addObject("page", new Object() {
            public String uri = "/mok/team";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("teams/team_addmember.twig");

        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/{username}/addmember")
    public ModelAndView addMember(final HttpServletRequest request,
            @PathVariable String username) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("username", username);
        mav.addObject("members", getFakeMembers());

        mav.addObject("page", new Object() {
            public String uri = "/mok/team";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("teams/team_addmember.twig");

        return mav;
    }

    public List<User> getFakeUsers() {
        List<User> teams = new ArrayList<>();

        User t = new User();
        t.setUsername("bert");
        t.setEmail("bert@bert.nl");
        t.setFullname("Bert Jansen");
        t.setUsername("De JavaDokters");
        teams.add(t);

        t = new User();
        t.setUsername("jan");
        t.setEmail("jandevries@home.nl");
        t.setFullname("Jan de Vries");
        t.setUsername("Stackers");
        teams.add(t);

        t = new User();
        t.setUsername("wim");
        t.setEmail("Wimmetje@hotmail.com");
        t.setFullname("Wim Krommetuin");
        t.setUsername("Numero Uno");
        teams.add(t);

        t = new User();
        t.setUsername("jan123");
        t.setEmail("WieIsDit@ergens.nl");
        t.setFullname("Jan de Hoop");
        t.setUsername("Code4Ever");
        teams.add(t);

        return teams;
    }

    public List<Member> getFakeMembers() {
        List<Member> members = new ArrayList<>();

        Member m = new Member();
        m.setId(0);
        m.setEmail("Jantje@jan.nl");
        m.setMembername("Jan de Jansen");
        m.setTeam("De JavaDokters");
        members.add(m);

        m = new Member();
        m.setId(2);
        m.setEmail("iemand@iets.nl");
        m.setMembername("Bert de Vries");
        m.setTeam("De JavaDokters");
        members.add(m);

        m = new Member();
        m.setId(34);
        m.setEmail("charles@gmail.com");
        m.setMembername("Charles Dickinson");
        m.setTeam("De JavaDokters");
        members.add(m);
        
        return members;
    }

}
