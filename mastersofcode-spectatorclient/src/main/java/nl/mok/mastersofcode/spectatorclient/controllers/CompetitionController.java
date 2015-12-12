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
@RequestMapping("/competition")
public class CompetitionController {
    
    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public ModelAndView showCompetition(final HttpServletRequest request, 
            @PathVariable int id) {
       
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/spec/competition/" + id;
            public String redirect = request.getRequestURL().toString();
        });
        
        mav.addObject("competition", DataController.getCompetitionById(id)
                .orElse(null));
        mav.addObject("currentCompetition", DataController.getCurrentCompetition());
        mav.addObject("currentRound", DataController.getCurrentRound());
        
        mav.setViewName("competition.twig");
        
        return mav;
    }

}
