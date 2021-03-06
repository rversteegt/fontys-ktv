/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.spectatorclient.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import nl.mok.mastersofcode.spectatorclient.controllers.data.DataController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.websockets.mok.endpoint.NewsFeedEndpoint;
import remote.ws.mok.domain.Round;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/round")
public class RoundController {
    
    private static final List<String> newsitems = 
            Collections.synchronizedList(new ArrayList<>());
    private static final NewsFeedEndpoint newsfeed = 
            new NewsFeedEndpoint(s -> newsitems.add(s));
    
    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public ModelAndView testDashboard(final HttpServletRequest request,
            @PathVariable int id) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/spec/round";
            public String redirect = request.getRequestURL().toString();
        });

        Round round = DataController.getRoundById(id).get();
        mav.addObject("round", round);
        mav.addObject("teams", DataController
                .getCompetitionById(round.getCompetition()).get().getTeams());
        mav.addObject("currentCompetition", DataController.getCurrentCompetition());
        mav.addObject("currentRound", DataController.getCurrentRound());
        mav.addObject("newsitems", newsitems);
        
        mav.setViewName("round.twig");
        
        return mav;
    }

}
