/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.spectatorclient.controllers.data;

import java.util.List;
import java.util.Optional;
import remote.ws.mok.domain.Competition;
import remote.ws.mok.domain.Round;
import remote.ws.mok.domain.User;
import remote.ws.mok.endpoint.CompetitionService;
import remote.ws.mok.endpoint.RoundService;
import remote.ws.mok.endpoint.UserService;

/**
 *
 * @author Gijs
 */
public class DataController {

    private static List<Competition> competitions;
    private static List<Round> rounds;
    private static List<User> users;
    private static Competition currentCompetition;
    private static Round currentRound;
    private static long lastRequestTime;
    private static final int interval = 30000; //millisec

    private static boolean requestNeeded() {
        return System.currentTimeMillis() - lastRequestTime > interval;
    }

    private static void refreshData() {
        if (requestNeeded()) {
            competitions = CompetitionService.all();
            rounds = RoundService.all();
            users = UserService.all();
            currentCompetition = CompetitionService.current();
            currentRound = RoundService.current();
            lastRequestTime = System.currentTimeMillis();
        }
    }

    public static List<Competition> getCompetitions() {
        refreshData();
        return competitions;
    }
    
    public static Optional<Competition> getCompetitionById(int id){
        refreshData();
        return competitions.stream().filter(c->c.getId()==id).findAny();
    }

    public static Competition getCurrentCompetition() {
        refreshData();
        return currentCompetition;
    }

    public static Optional<Round> getRoundById(int id){
        refreshData();
        return rounds.stream().filter(r->r.getId() == id).findAny();
    }
    
    public static Round getCurrentRound() {
        refreshData();
        return currentRound;
    }
    
    public static Optional<User> getTeamById(String username){
        refreshData();
        return users.stream()
                .filter(u->u.getUsername().equals(username)).findAny();
    }
    
}
