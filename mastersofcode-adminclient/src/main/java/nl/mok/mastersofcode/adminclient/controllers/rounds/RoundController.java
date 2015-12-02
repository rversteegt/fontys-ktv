package nl.mok.mastersofcode.adminclient.controllers.competitions;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import nl.mok.mastersofcode.adminclient.helpers.RoundHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Assignment;
import remote.ws.mok.domain.Round;
import remote.ws.mok.endpoint.AssignmentService;
import remote.ws.mok.endpoint.AuthenticatedSession;
import remote.ws.mok.endpoint.RoundService;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/rounds")
public class RoundController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRounds(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/rounds";
            public String redirect = request.getRequestURL().toString();
        });

        AuthenticatedSession.login("admin", "admin");
        mav.addObject("rounds", RoundService.all());
        
        mav.setViewName("rounds/rounds.twig");

        return mav;
    }  

}
