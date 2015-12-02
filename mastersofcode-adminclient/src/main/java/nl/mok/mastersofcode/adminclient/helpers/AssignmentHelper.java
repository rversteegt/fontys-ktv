/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.helpers;

import java.util.Optional;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import remote.ws.mok.domain.Assignment;
import remote.ws.mok.domain.Hint;

/**
 *
 * @author Gijs
 */
public class AssignmentHelper {

    /**
     * Creates an Assignment object from a request, returns null if correct
     * parameters not present or empty
     *
     * @param request
     * @param currentArtifact artifact of assignment to be updated or NULL if
     * new assignment
     * @return
     */
    public static Optional<Assignment> createAssignment(
            HttpServletRequest request, String currentArtifact) {

        String artifact = currentArtifact == null ? request.getParameter("artifact") : currentArtifact;
        String name = request.getParameter("name");
        String participantDescription = request.getParameter("participantDescription");
        String spectatorDescription = request.getParameter("spectatorDescription");
        String creatorName = request.getParameter("creatorName");
        String creatorOrganisation = request.getParameter("creatorOrganisation");
        String creatorLink = request.getParameter("creatorLink");

        Optional<Assignment> assignmentOpt = Optional.empty();
        
        try{
            if(!(artifact.isEmpty() || 
                    name.isEmpty() || 
                    participantDescription.isEmpty() ||
                    spectatorDescription.isEmpty() ||
                    creatorName.isEmpty() ||
                    creatorOrganisation.isEmpty() ||
                    creatorLink.isEmpty()
                    )) {
                
                Assignment assignment = new Assignment();
                assignment.setArtifact(artifact);
                assignment.setName(name);
                assignment.setParticipantDescription(participantDescription);
                assignment.setSpectatorDescription(spectatorDescription);
                assignment.setCreatorName(creatorName);
                assignment.setCreatorOrganisation(creatorOrganisation);
                assignment.setCreatorLink(creatorLink);
                assignmentOpt = Optional.of(assignment);
            }
        } catch(NullPointerException ex){
            //parameter not available
        }
        
        return assignmentOpt;
    }

    public static Assignment addHint(Assignment assignment, Hint hint) {

        assignment.setHints(
                Stream.concat(
                        assignment.getHints().stream(),
                        Stream.of(hint)).collect(toList())
        );

        return assignment;
    }

}
