package remote.ws.mok.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;

/**
 *
 * @author Robert
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Competition {
	private int id;
        
	private String title;
        
	private String description;
        
	private Set<Team> teams;
        
	private Set<Round> rounds;
        
}
