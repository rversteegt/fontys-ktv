package remote.ws.mok.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Robert
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Round {
    
    private int id;
    
    private int competition;
    
    private int duration;
    
    private int multiplier;
    
    private Assignment assigment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompetition() {
        return competition;
    }

    public void setCompetition(int competition) {
        this.competition = competition;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public Assignment getAssigment() {
        return assigment;
    }

    public void setAssigment(Assignment assigment) {
        this.assigment = assigment;
    }
    
    
}
