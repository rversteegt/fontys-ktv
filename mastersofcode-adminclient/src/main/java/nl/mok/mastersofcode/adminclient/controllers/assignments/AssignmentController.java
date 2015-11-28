/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.controllers.assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import remote.ws.mok.domain.Assignment;
import remote.ws.mok.domain.Hint;

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
        
        mav.addObject("assignments", getFakeAssignments());
        
        mav.addObject("page", new Object() {
            public String uri = "/mok/assignments";
            public String redirect = request.getRequestURL().toString();
        });

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
        assignment.setHints(getFakeHints());
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
    
    
    
    public List<Assignment> getFakeAssignments(){
        List<Assignment> ass = new ArrayList<>();
        
        Assignment a = new Assignment();
        a.setArtifact("Artifact1.zip");
        a.setName("De webshop plugin");
        a.setParticipantDescription("Bouw een aanvullende module op een bestaande webshop");
        a.setSpectatorDescription("Deelnemers bouwen een webshop");
        a.setHints(getFakeHints());
        ass.add(a);
        
        a = new Assignment();
        a.setArtifact("Artifact2.jar");
        a.setName("Het patienten dossier");
        a.setParticipantDescription("Zorg voor een opbouw van patientengegevens in een overzichtelijk dashboard");
        a.setSpectatorDescription("Deelnemers bouwen elektronisch patientendossier");
        a.setHints(getFakeHints());
        ass.add(a);
        
        return ass;
    }

    public Set<Hint> getFakeHints(){
        Set<Hint> hints = new HashSet<>();
        
        Hint hint = new Hint();
        hint.setAssignment("De webshop plugin");
        hint.setId(1);
        hint.setText("Extra punten voor een interactieve winkelwagen");
        hint.setTime(1200);
        hints.add(hint);
        
        hint = new Hint();
        hint.setAssignment("De webshop plugin");
        hint.setId(3);
        hint.setText("Betalingen hoeven niet via een https verbinding");
        hint.setTime(2400);
        hints.add(hint);
        
        return hints;
    }
    
}
