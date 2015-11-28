package nl.mok.mastersofcode.adminclient.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("dashboard/index.twig");
        
        return mav;
    }
}
