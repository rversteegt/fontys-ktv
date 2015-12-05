package nl.mok.mastersofcode.adminclient.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.endpoint.AuthenticatedSession;
import remote.ws.mok.endpoint.CompetitionService;
import remote.ws.mok.endpoint.RoundService;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/")
public class DashboardController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(final HttpServletRequest request) {
        return showDashboard(request);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "dashboard")
    public ModelAndView showDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        AuthenticatedSession.login("admin", "admin");
        //CompetitionService.start("999");
        //RoundService.start("892");
        
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("dashboard/index.twig");
        
        return mav;
    }
}
