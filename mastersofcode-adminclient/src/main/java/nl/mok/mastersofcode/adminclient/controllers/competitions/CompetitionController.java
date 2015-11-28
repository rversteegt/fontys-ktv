package nl.mok.mastersofcode.adminclient.controllers.competitions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Competition;
import remote.ws.mok.endpoint.AuthenticatedSession;
import remote.ws.mok.endpoint.CompetitionService;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/competitions")
public class CompetitionController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showCompetitions(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/competition";
            public String redirect = request.getRequestURL().toString();
        });

        AuthenticatedSession.login("admin", "admin");
        
        List<Competition> competitions = CompetitionService.all();
        
        mav.addObject("competitions", competitions);
        
        mav.setViewName("competitions/index.twig");
        
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/new")
    public ModelAndView showNewCompetition(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/new";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("competitions/competition_new.twig");
        
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public ModelAndView addNewCompetition(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/new";
            public String redirect = request.getRequestURL().toString();
        });
        
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        
        Competition competition = new Competition();
        competition.setTitle(title);
        competition.setDescription(description);
        
        System.out.println(competition.getTitle());
        System.out.println(competition.getDescription());
        
        AuthenticatedSession.login("admin", "admin");
        CompetitionService.add(competition);
        
                
        mav.setViewName("competitions/index.twig");
        
        return mav;
    }

}
