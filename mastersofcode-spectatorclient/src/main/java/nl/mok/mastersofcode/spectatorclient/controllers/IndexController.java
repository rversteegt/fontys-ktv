/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.spectatorclient.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Competition;
import remote.ws.mok.domain.Round;
import remote.ws.mok.endpoint.CompetitionService;
import remote.ws.mok.endpoint.RoundService;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/")
public class IndexController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView testDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();        
        
        mav.addObject("page", new Object() {
            public String uri = "/spec/";
            public String redirect = request.getRequestURL().toString();
        });
        
        mav.addObject("competitions", CompetitionService.all());
        mav.addObject("currentCompetition", CompetitionService.current());
        mav.addObject("currentRound", RoundService.current());
        
        mav.setViewName("index.twig");
        
        return mav;
    }

}