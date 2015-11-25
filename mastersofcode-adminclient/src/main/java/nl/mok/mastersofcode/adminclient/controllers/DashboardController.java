/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Competition;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/")
public class DashboardController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/dashboard";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("dashboard/index.twig");
        
        return mav;
    }
    
}
