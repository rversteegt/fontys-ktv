package nl.mok.mastersofcode.adminclient.controllers.assignments;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Assignment;
import remote.ws.mok.domain.Competition;
import remote.ws.mok.domain.Hint;
import remote.ws.mok.endpoint.AssignmentService;
import remote.ws.mok.endpoint.AuthenticatedSession;
import remote.ws.mok.endpoint.CompetitionService;

/**
 *
 * @author Gijs
 */
@Controller
@RequestMapping("/assignments")
public class AssignmentController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAssignments(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/assignments";
            public String redirect = request.getRequestURL().toString();
        });
        
        AuthenticatedSession.login("admin", "admin");
        List<Assignment> assignments = AssignmentService.all();
        mav.addObject("assignments", assignments);

        mav.setViewName("assignments/assignments.twig");
        
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/new")
    public ModelAndView showNewAssignment(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/assignments/new";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("assignments/assignments_new.twig");
        
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/new")
    public ModelAndView addNewAssignment(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/assignments/new";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("assignments/assignments_new.twig");
        
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/{artifact}")
    public ModelAndView showAssignment(final HttpServletRequest request,
            @PathVariable String artifact) {
        ModelAndView mav = new ModelAndView();
        
        Assignment assignment = new Assignment();
        assignment.setArtifact(artifact);
        assignment.setName("De webshop plugin");
        assignment.setParticipantDescription("Bouw een aanvullende module op een bestaande webshop");
        assignment.setSpectatorDescription("Deelnemers bouwen een webshop");
        assignment.setCreatorName("Bert Jansen");
        assignment.setCreatorOrganisation("Jansen BV");
        assignment.setCreatorLink("http://www.jansenbv.nl");
        mav.addObject("assignment", assignment);
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/assignment";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("assignments/assignment.twig");
        
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/{artifact}/addhint")
    public ModelAndView showAddHint(final HttpServletRequest request,
            @PathVariable String artifact) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("artifact", artifact);
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/assignment";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("assignments/assignment_addhint.twig");
        
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/{artifact}/addhint")
    public ModelAndView addHint(final HttpServletRequest request,
            @PathVariable String artifact) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("artifact", artifact);
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/assignment";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("assignments/assignment_addhint.twig");
        
        return mav;
    }
    
}
