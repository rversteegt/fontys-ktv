package nl.mok.mastersofcode.adminclient.controllers.competitions;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import nl.mok.mastersofcode.adminclient.helpers.CompetitionHelper;
import nl.mok.mastersofcode.adminclient.helpers.RoundHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Assignment;
import remote.ws.mok.domain.Competition;
import remote.ws.mok.domain.Round;
import remote.ws.mok.endpoint.AssignmentService;
import remote.ws.mok.endpoint.AuthenticatedSession;
import remote.ws.mok.endpoint.CompetitionService;
import remote.ws.mok.endpoint.RoundService;
import remote.ws.mok.endpoint.UserService;

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

        mav.addObject("page", new Object() {
            public String uri = "/mok/competition";
            public String redirect = request.getRequestURL().toString();
        });

        AuthenticatedSession.login("admin", "admin");

        List<Competition> competitions = CompetitionService.all();

        mav.addObject("competitions", competitions);

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
    public ModelAndView addCompetition(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/new";
            public String redirect = request.getRequestURL().toString();
        });

        Optional<Competition> competition = CompetitionHelper
                .createCompetition(request, null);

        if (competition.isPresent()) {
            AuthenticatedSession.login("admin", "admin");
            CompetitionService.add(competition.get());
        }

        mav.setViewName("redirect:/mok/competitions");

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView showCompetitionDetail(@PathVariable("id") int id,
            final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/new";
            public String redirect = request.getRequestURL().toString();
        });

        AuthenticatedSession.login("admin", "admin");
        mav.addObject("competition", CompetitionService.byId(id));

        mav.setViewName("competitions/competition.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/addround")
    public ModelAndView showAddRoundToCompetition(final HttpServletRequest request,
            @PathVariable("id") int id) {

        ModelAndView mav = new ModelAndView();

        AuthenticatedSession.login("admin", "admin");

        List<Assignment> assignments = AssignmentService.all();
        mav.addObject("assignments", assignments);
        
        Competition competition = CompetitionService.byId(id);
        mav.addObject("competition", competition);

        mav.setViewName("competitions/competition_addround.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/addround")
    public ModelAndView addRoundToCompetition(final HttpServletRequest request,
            @PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/" + id;
            public String redirect = request.getRequestURL().toString();
        });
        
        Assignment assignment = AssignmentService
                .byId(request.getParameter("assignment"));
        
        Optional<Round> round = RoundHelper
                .createRound(request, null, assignment, id);
        
        if(round.isPresent()){
            AuthenticatedSession.login("admin", "admin");
            RoundService.add(round.get());
        }
       
        mav.setViewName("redirect:/mok/competitions/" + id);

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ModelAndView updateCompetition(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/new";
            public String redirect = request.getRequestURL().toString();
        });

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Competition competition = new Competition();
        competition.setTitle(title);
        competition.setDescription(description);

        AuthenticatedSession.login("admin", "admin");
        CompetitionService.update(competition);

        mav.setViewName("redirect:/mok/competitions");

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/addteam")
    public ModelAndView showAddTeams(@PathVariable("id") int id,
            final HttpServletRequest request) {
        ModelAndView mav = showCompetitionDetail(id, request);

        //add competitions + rename teams to users in twig
        //competition_addteam.twig
        mav.addObject("users", UserService.all());

        mav.setViewName("competitions/competition_addteam.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/addteam")
    public ModelAndView addTeams(@PathVariable("id") int id,
            final HttpServletRequest request) {
        ModelAndView mav = showCompetitionDetail(id, request);

        request.getParameter("team_id");

        mav.addObject("users", UserService.all());

        mav.setViewName("competitions/competition_addteam.twig");

        return mav;
    }
}
