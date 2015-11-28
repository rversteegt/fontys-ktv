package nl.mok.mastersofcode.adminclient.controllers.assignments;

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
@RequestMapping("/assignments")
public class AssignmentController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView testDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/assignments";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("assignments/assignments.twig");
        
        return mav;
    }

}
