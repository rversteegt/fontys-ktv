/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.spectatorclient.controllers;

import javax.servlet.http.HttpServletRequest;
import nl.mok.mastersofcode.spectatorclient.controllers.data.DataController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public ModelAndView showTeam(final HttpServletRequest request,
            @PathVariable String username) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/spec/team";
            public String redirect = request.getRequestURL().toString();
        });

        mav.addObject("team", DataController.getTeamById(username).orElse(null));
        mav.addObject("currentCompetition", DataController.getCurrentCompetition());
        mav.addObject("currentRound", DataController.getCurrentRound());
        
        mav.setViewName("team.twig");

        return mav;
    }

}
