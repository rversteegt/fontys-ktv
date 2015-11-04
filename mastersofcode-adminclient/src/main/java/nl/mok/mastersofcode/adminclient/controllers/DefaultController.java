/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.controllers;

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
@RequestMapping("/dashboard")
public class DefaultController {

//    @RequestMapping(value="/", method= RequestMethod.GET)
//    public String index(ModelMap map) {
//        map.addAttribute("hello", "test!");
//        return "index";
//    }
    /**
     * Displays the main dashboard for producers.
     *
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

//        mav.addObject("page", new Object() {
//            public String lang = request.getSession().
//                    getAttribute("lang").toString();
//            public String uri = "/producer/dashboard";
//            public String redirect = request.getRequestURL().toString();
//        });
//        mav.setViewName("producer/dashboard/index.twig");
        
        mav.addObject("page", new Object() {
            public String uri = "/mastersofcode-adminclient/dashboard";
            public String redirect = request.getRequestURL().toString();
        });
        mav.addObject("hello", "test");
        mav.setViewName("index");
        
        System.out.println("IETS");
        
        return mav;
    }

}
