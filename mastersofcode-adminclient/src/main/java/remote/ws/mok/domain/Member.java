package remote.ws.mok.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Robert
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {

    private int id;
    
    private String team;
    
    private String membername;
    
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
