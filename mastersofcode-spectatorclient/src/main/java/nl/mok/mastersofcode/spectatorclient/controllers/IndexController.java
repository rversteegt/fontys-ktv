/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.spectatorclient.controllers;

import javax.servlet.http.HttpServletRequest;
import nl.mok.mastersofcode.spectatorclient.controllers.data.DataController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/")
public class IndexController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showIndex(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();        
        
        mav.addObject("page", new Object() {
            public String uri = "/spec/";
            public String redirect = request.getRequestURL().toString();
        });
        
        mav.addObject("competitions", DataController.getCompetitions());
        mav.addObject("currentCompetition", DataController.getCurrentCompetition());
        mav.addObject("currentRound", DataController.getCurrentRound());
        
        mav.setViewName("index.twig");
        
        return mav;
    }

}
