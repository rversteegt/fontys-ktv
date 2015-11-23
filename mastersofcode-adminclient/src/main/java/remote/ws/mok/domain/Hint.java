package remote.ws.mok.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Robert
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hint {
    
    private int id;
    
    private String assignment;
    
    private String text;
    
    private int time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
}
