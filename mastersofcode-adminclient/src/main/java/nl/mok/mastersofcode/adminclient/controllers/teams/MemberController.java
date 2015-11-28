package nl.mok.mastersofcode.adminclient.controllers.teams;

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
@RequestMapping("/members")
public class MemberController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView testDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/members";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("teams/members.twig");
        
        return mav;
    }

}
