package nl.mok.mastersofcode.adminclient.controllers.teams;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import nl.mok.mastersofcode.adminclient.helpers.MemberHelper;
import nl.mok.mastersofcode.adminclient.helpers.UserHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Member;
import remote.ws.mok.domain.User;
import remote.ws.mok.endpoint.AuthenticatedSession;
import remote.ws.mok.endpoint.UserService;

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

        AuthenticatedSession.login("admin", "admin");
        List<User> teams = UserService.allOfRole("team");
        mav.addObject("teams", teams);

        mav.addObject("page", new Object() {
            public String uri = "/mok/teams";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("teams/teams.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/new")
    public ModelAndView showAddUser(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/teams/new";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("teams/teams_new.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public ModelAndView addUser(final HttpServletRequest request) {

        Optional<User> user = UserHelper.createUser(request);

        if (user.isPresent()) {
            AuthenticatedSession.login("admin", "admin");
            UserService.add(user.get());
        }

        return new ModelAndView("redirect:/mok/teams");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public ModelAndView showUser(final HttpServletRequest request,
            @PathVariable String username) {
        ModelAndView mav = new ModelAndView();

        AuthenticatedSession.login("admin", "admin");
        mav.addObject("team", UserService.byId(username));

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

        Optional<Member> member = MemberHelper
                .createMember(request, username);

        if (member.isPresent()) {
            AuthenticatedSession.login("admin", "admin");
            User user = UserHelper.addMember(UserService.byId(username), member.get());
            UserService.update(user);
        }

        return new ModelAndView("redirect:/mok/teams/" + username);
    }

}
