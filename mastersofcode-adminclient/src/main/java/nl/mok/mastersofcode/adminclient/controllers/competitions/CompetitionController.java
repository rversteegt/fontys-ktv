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
import remote.ws.mok.domain.Assignment;
import remote.ws.mok.domain.Competition;
import remote.ws.mok.domain.Round;

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

        mav.addObject("competitions", getFakeCompetitions());

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

    @RequestMapping(method = RequestMethod.POST, value = "/new")
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

        Competition c = new Competition();
        c.setTitle("De winkelwagen");
        c.setDescription("Zorg voor een gebruikersvriendelijke en intuitieve winkelwagen");
        
        mav.addObject("competition", c);
        mav.addObject("rounds", getFakeRounds());
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/competition";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("competitions/competition.twig");

        return mav;
    }

    public List<Competition> getFakeCompetitions() {
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

    public List<Round> getFakeRounds() {
        List<Round> rounds = new ArrayList<>();

        Round r = new Round();
        Assignment a = new Assignment();
        a.setName("Dit is de opdrachtnaam");
        r.setId(1);
        r.setDuration(3600);
        r.setMultiplier(1);
        rounds.add(r);
        
        a.setName("De winkelwagen");
        r.setId(2);
        r.setDuration(4655);
        r.setMultiplier(3);
        rounds.add(r);

        return rounds;
    }
    
}
