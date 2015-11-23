package nl.mok.mastersofcode.adminclient.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Competition;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/dashboard";
            public String redirect = request.getRequestURL().toString();
        });
        
        mav.setViewName("dashboard/index.twig");
        
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/competitions"})
    public ModelAndView displayCompetitions(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/dashboard/competitions";
            public String redirect = request.getRequestURL().toString();
        });
        
        mav.setViewName("dashboard/competitions.twig");
        
        return mav;
    }
}
