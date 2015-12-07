/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.helpers;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import remote.ws.mok.domain.Assignment;
import remote.ws.mok.domain.Round;

/**
 *
 * @author Gijs
 */
public class RoundHelper {
        
    /**
     * Creates a Round object from a request, returns null if correct
     * parameters not present or empty
     * 
     * @param request 
     * @param assignment assignment of round
     * @param competitionId Id of linked competition
     * @return 
     */
    public static Optional<Round> createRound(
        HttpServletRequest request, Assignment assignment, 
            Integer competitionId){
        
        Integer duration = Parser.parseInt(request.getParameter("duration"))
                .orElse(null);
        Integer multiplier = Parser.parseInt(request.getParameter("multiplier"))
                .orElse(null);
        
        if(duration == null || multiplier == null){
            return Optional.empty();
        } else {
            Round round = new Round();
            round.setAssignment(assignment);
            round.setDuration(duration);
            round.setMultiplier(multiplier);
            round.setCompetition(competitionId);
            return Optional.of(round);
        } 
    }
    
    /**
     * updates a round with new values placed in the request
     * 
     * @param request
     * @param assignment to be added to round
     * @param round round to be updated
     * @return updated round
     */
    public static Optional<Round> updateRound(
        HttpServletRequest request, Assignment assignment, Round round){
        
        Integer duration = Parser.parseInt(request.getParameter("duration"))
                .orElse(null);
        Integer multiplier = Parser.parseInt(request.getParameter("multiplier"))
                .orElse(null);
        
        if(duration == null || multiplier == null){
            return Optional.empty();
        } else {
            round.setAssignment(assignment);
            round.setDuration(duration);
            round.setMultiplier(multiplier);
            return Optional.of(round);
        }
    }
    
}
