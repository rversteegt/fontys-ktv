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
import remote.ws.mok.domain.Team;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/competitions")
public class CompetitionController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showCompetitions(final HttpServletRequest request) {
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
    public ModelAndView showCompetition(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        Competition c = new Competition();
        c.setTitle("De winkelwagen");
        c.setDescription("Zorg voor een gebruikersvriendelijke en intuitieve winkelwagen");
        
        mav.addObject("competition", c);
        mav.addObject("rounds", getFakeRounds());
        mav.addObject("teams", getFakeTeams());
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/competition";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("competitions/competition.twig");

        return mav;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}/addround")
    public ModelAndView showAddRoundToCompetition(final HttpServletRequest request) {
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

        mav.setViewName("competitions/competition_addround.twig");

        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/{id}/addround")
    public ModelAndView addRoundToCompetition(final HttpServletRequest request) {
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

        mav.setViewName("competitions/competition_addround.twig");

        return mav;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}/addteam")
    public ModelAndView showAddTeamToCompetition(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        Competition c = new Competition();
        c.setTitle("De winkelwagen");
        c.setDescription("Zorg voor een gebruikersvriendelijke en intuitieve winkelwagen");
        
        mav.addObject("competition", c);
        mav.addObject("teams", getFakeTeams());
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/competition";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("competitions/competition_addteam.twig");

        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/{id}/addteam")
    public ModelAndView addTeamToCompetition(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        Competition c = new Competition();
        c.setTitle("De winkelwagen");
        c.setDescription("Zorg voor een gebruikersvriendelijke en intuitieve winkelwagen");
        
        mav.addObject("competition", c);
        mav.addObject("teams", getFakeTeams());
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/competition";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("competitions/competition_addteam.twig");

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
        r.setAssignment(a);
        rounds.add(r);
        
        Round r2 = new Round();
        Assignment a2 = new Assignment();
        a2.setName("De winkelwagen");
        r2.setId(2);
        r2.setDuration(4655);
        r2.setMultiplier(3);
        r2.setAssignment(a2);
        rounds.add(r2);
        
        return rounds;
    }
    
    public List<Team> getFakeTeams(){
        List<Team> teams = new ArrayList<>();
        
        Team t = new Team();
        t.setUsername("doc1");
        t.setTeamname("De JavaDokters");
        t.setFullname("Henk Westbroek");
        teams.add(t);
        
        t = new Team();
        t.setUsername("St@ck");
        t.setTeamname("Stackers");
        t.setFullname("Guus de Broek");
        teams.add(t);
        
        t = new Team();
        t.setUsername("Uno1");
        t.setTeamname("Numero Uno");
        t.setFullname("Willem Heijnen");
        teams.add(t);
        
        return teams;
    }
    
}
