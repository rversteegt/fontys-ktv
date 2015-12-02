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
import remote.ws.mok.domain.Competition;
import remote.ws.mok.domain.User;

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
     * @param id id of competition to be updated or NULL if new competition
     * @return 
     */
    public static Optional<Competition> createCompetition(
        HttpServletRequest request, Integer id){
        
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        
        if(title == null || title.isEmpty() || description == null || description.isEmpty()){
            return Optional.empty();
        } else {
            Competition comp = new Competition();
            comp.setTitle(title);
            comp.setDescription(description);
            
            if(id!=null){
                comp.setId(id);
            }
            
            return Optional.of(comp);
        }
        
    }
    
    public static Competition addUser(Competition competition, User user) {

        competition.setTeams(
                Stream.concat(competition.getTeams().stream(), 
                        Stream.of(user)).collect(toList())
        );

        return competition;
    }
    
}
