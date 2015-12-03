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

        Optional<Competition> competition = CompetitionHelper
                .createCompetition(request);

        if (competition.isPresent()) {
            AuthenticatedSession.login("admin", "admin");
            CompetitionService.add(competition.get());
        }

        return new ModelAndView("redirect:/mok/competitions");
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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/update")
    public ModelAndView showUpdateCompetition(@PathVariable("id") int id,
            final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/" + id + "/update";
            public String redirect = request.getRequestURL().toString();
        });

        AuthenticatedSession.login("admin", "admin");
        mav.addObject("competition", CompetitionService.byId(id));

        mav.setViewName("competitions/competition_update.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/update")
    public ModelAndView updateCompetition(@PathVariable("id") int id,
            final HttpServletRequest request) {

        AuthenticatedSession.login("admin", "admin");
        Optional<Competition> competitionOpt = CompetitionHelper
                .updateCompetition(request, CompetitionService.byId(id));

        if (competitionOpt.isPresent()) {
            CompetitionService.update(competitionOpt.get());
        }

        return new ModelAndView("redirect:/mok/competitions/");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/addround")
    public ModelAndView showAddRoundToCompetition(final HttpServletRequest request,
            @PathVariable("id") int id) {

        ModelAndView mav = new ModelAndView();

        AuthenticatedSession.login("admin", "admin");

        mav.addObject("assignments", AssignmentService.all());
        mav.addObject("competition", CompetitionService.byId(id));

        mav.setViewName("competitions/competition_addround.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/addround")
    public ModelAndView addRoundToCompetition(final HttpServletRequest request,
            @PathVariable("id") int id) {

        Assignment assignment = AssignmentService
                .byId(request.getParameter("assignment"));

        Optional<Round> round = RoundHelper
                .createRound(request, assignment, id);

        if (round.isPresent()) {
            AuthenticatedSession.login("admin", "admin");
            RoundService.add(round.get());
        }

        return new ModelAndView("redirect:/mok/competitions/" + id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/addteam")
    public ModelAndView showAddTeams(@PathVariable("id") int competitionId,
            final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/" + competitionId + "/addteam";
            public String redirect = request.getRequestURL().toString();
        });

        AuthenticatedSession.login("admin", "admin");
        mav.addObject("teams", UserService.allOfRole("team"));

        mav.setViewName("competitions/competition_addteam.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/addteam")
    public ModelAndView addTeams(@PathVariable("id") int competitionId,
            final HttpServletRequest request) {

        AuthenticatedSession.login("admin", "admin");

        Competition competition = CompetitionHelper.addUser(
                CompetitionService.byId(competitionId),
                UserService.byId(request.getParameter("team")));

        CompetitionService.update(competition);

        return new ModelAndView("redirect:/mok/competitions/" + competitionId);
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/{competitionId}/{roundId}/update")
    public ModelAndView showUpdateRound(final HttpServletRequest request,
            @PathVariable("competitionId") int competitionId,
            @PathVariable("roundId") int roundId) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("page", new Object() {
            public String uri = "/mok/competitions/" + competitionId + 
                    "/" + roundId + "/updateround";
            public String redirect = request.getRequestURL().toString();
        });

        AuthenticatedSession.login("admin", "admin");

        mav.addObject("assignments", AssignmentService.all());
        mav.addObject("competition", CompetitionService.byId(competitionId));
        mav.addObject("round", RoundService.byId(roundId));

        mav.setViewName("competitions/competition_updateround.twig");

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/{competitionId}/{roundId}/update")
    public ModelAndView updateRound(final HttpServletRequest request,
            @PathVariable("competitionId") int competitionId,
            @PathVariable("roundId") int roundId) {

        AuthenticatedSession.login("admin", "admin");

        Optional<Round> roundOpt = RoundHelper.updateRound(
                request,
                AssignmentService.byId(request.getParameter("assignment")),
                RoundService.byId(roundId));

        if (roundOpt.isPresent()) {
            RoundService.update(roundOpt.get());
        }

        return new ModelAndView("redirect:/mok/competitions/" + competitionId);
    }

}
