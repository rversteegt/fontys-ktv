package nl.mok.mastersofcode.adminclient.controllers.competitions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.endpoint.AuthenticatedSession;
import remote.ws.mok.endpoint.RoundService;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/rounds/{id}")
public class RoundController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRounds(final HttpServletRequest request, 
            @PathVariable int id) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/rounds/" + id;
            public String redirect = request.getRequestURL().toString();
        });

        AuthenticatedSession.login("admin", "admin");
        mav.addObject("round", RoundService.byId(id));
        
        mav.setViewName("rounds/round.twig");

        return mav;
    }  

}
