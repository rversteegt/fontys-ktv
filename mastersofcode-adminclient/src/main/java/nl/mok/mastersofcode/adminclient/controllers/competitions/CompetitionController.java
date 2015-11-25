/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.controllers.competitions;

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
@RequestMapping("/competitions")
public class CompetitionController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("competitions", getFakeData());

        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("competitions/competitions.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/new")
    public ModelAndView showNewCompetition(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/new";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("competitions/competition_new.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/competitions/new")
    public ModelAndView addNewCompetition(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/new";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("competitions/competition_new.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView testDashboard(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/competition";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("competitions/competition.twig");

        return mav;
    }

    public List<Competition> getFakeData() {
        List<Competition> competitions = new ArrayList<>();

        Competition c1 = new Competition();
        c1.setId(1);
        c1.setTitle("Titel wedstrijd 1");
        c1.setDescription("Dit is een testwedstrijd");
        competitions.add(c1);

        c1 = new Competition();
        c1.setId(2);
        c1.setTitle("JavaMastersGame2");
        c1.setDescription("Nog een wedstrijd");
        competitions.add(c1);

        return competitions;
    }

}
