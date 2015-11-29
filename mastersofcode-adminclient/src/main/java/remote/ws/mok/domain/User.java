package remote.ws.mok.domain;

import java.util.List;

/**
 *
 * @author Robert
 */
public class User {
    
    private String username;
    
    private String password;
    
    private String fullname;
    
    private String teamname;
    
    private String email;
    
    private String role;
    
    private String node;
    
    private double totalscore;
    
    private List<Member> members;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public double getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(double totalscore) {
        this.totalscore = totalscore;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
    
    
}
