package nl.mok.mastersofcode.adminclient.controllers.assignments;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import nl.mok.mastersofcode.adminclient.helpers.AssignmentHelper;
import nl.mok.mastersofcode.adminclient.helpers.HintHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Assignment;
import remote.ws.mok.domain.Hint;
import remote.ws.mok.endpoint.AssignmentService;
import remote.ws.mok.endpoint.AuthenticatedSession;

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

        mav.setViewName("assignments/assignment_new.twig");
        
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/new")
    public ModelAndView addNewAssignment(final HttpServletRequest request) {
        
        Optional<Assignment> assignmentOpt = AssignmentHelper
                .createAssignment(request);
        
        if(assignmentOpt.isPresent()){
            AuthenticatedSession.login("admin", "admin");
            AssignmentService.add(assignmentOpt.get());
        }

        return new ModelAndView("redirect:/mok/assignments");
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/{artifact}/update")
    public ModelAndView showUpdateAssignment(final HttpServletRequest request, 
            @PathVariable(value = "artifact") String artifact) {
        ModelAndView mav = new ModelAndView();
        
        AuthenticatedSession.login("admin", "admin");
        mav.addObject("assignment", AssignmentService.byId(artifact));
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/assignment";
            public String redirect = request.getRequestURL().toString();
        });

        mav.setViewName("assignments/assignment_update.twig");
        
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/{artifact}/update")
    public ModelAndView updateAssignment(final HttpServletRequest request, 
            @PathVariable(value = "artifact") String artifact) {
        AssignmentHelper.createAssignment(request).ifPresent(a -> {
            AuthenticatedSession.login("admin", "admin");
            AssignmentService.update(a);
        });
        
        return new ModelAndView("redirect:/mok/assignments");
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/{artifact:.+}")
    public ModelAndView showAssignment(final HttpServletRequest request,
            @PathVariable String artifact) {
        ModelAndView mav = new ModelAndView();
        
        AuthenticatedSession.login("admin", "admin");
        mav.addObject("assignment", AssignmentService.byId(artifact));
        
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
        
        mav.addObject("assignment", artifact);
        
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
        
        Optional<Hint> hintOpt = HintHelper.createHint(request);
        
        if(hintOpt.isPresent()){
            AuthenticatedSession.login("admin", "admin");
            Assignment assignment = AssignmentHelper.addHint(
                    AssignmentService.byId(artifact),
                    hintOpt.get()
            );
            AssignmentService.update(assignment);
        }
        
        return new ModelAndView("redirect:/mok/assignments/" + artifact);
    }
    
}
