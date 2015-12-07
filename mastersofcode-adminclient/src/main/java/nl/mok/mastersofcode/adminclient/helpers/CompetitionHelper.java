/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.helpers;

import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import remote.ws.mok.domain.Competition;
import remote.ws.mok.domain.Round;
import remote.ws.mok.domain.User;
import static remote.ws.mok.endpoint.CompetitionService.add;
import static remote.ws.mok.endpoint.RoundService.delete;

/**
 *
 * @author Gijs
 */
public class CompetitionHelper {
        
    /**
     * Creates a Competition object from a request, returns null if correct
     * parameters not present or empty
     * 
     * @param request
     * @return 
     */
    public static Optional<Competition> createCompetition(
        HttpServletRequest request){
        
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        
        if(title == null || title.isEmpty() || description == null || description.isEmpty()){
            return Optional.empty();
        } else {
            Competition comp = new Competition();
            comp.setTitle(title);
            comp.setDescription(description);
            return Optional.of(comp);
        }
        
    }
    
    /**
     * updates a competition with new values placed in the request
     * 
     * @param request
     * @param competition competition to be updated
     * @return updated competition
     */
    public static Optional<Competition> updateCompetition(
        HttpServletRequest request, Competition competition){
        
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        
        if(title == null || title.isEmpty() || description == null || description.isEmpty()){
            return Optional.empty();
        } else {
            competition.setTitle(title);
            competition.setDescription(description);
            return Optional.of(competition);
        }
        
    }
    
    public static Competition addUser(Competition competition, User user) {

        competition.setTeams(
                Stream.concat(competition.getTeams().stream(), 
                        Stream.of(user)).collect(toList())
        );

        return competition;
    }
    
    /**
     * Sets the rounds of this competition.
     * @param competition the competition
     * @param rounds the rounds
     */
    public static void setRounds(Competition competition, List<Round> rounds) {
        competition.setRounds(rounds);
    }
}
