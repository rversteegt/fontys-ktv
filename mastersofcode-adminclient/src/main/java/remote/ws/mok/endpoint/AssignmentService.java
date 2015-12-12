package remote.ws.mok.endpoint;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import remote.ws.mok.domain.Assignment;

/**
 *
 * @author Robert
 */
public class AssignmentService extends AuthenticatedSession {
    private final static String endpoint = 
            "http://localhost:8083/api/assignments/";
    private final static RestTemplate template = new RestTemplate();
    
    public static List<Assignment> all() {
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET, 
                new HttpEntity<>(null, credentials()), 
                Assignment[].class).getBody());
    }
    
    public static void add(Assignment assignment) {
        template.exchange(endpoint, HttpMethod.POST,
                new HttpEntity<>(assignment, credentials()), String.class);                
    }
    
    public static void update(Assignment assignment) {
        template.exchange(endpoint, HttpMethod.PUT,
                new HttpEntity<>(assignment, credentials()), String.class);                
    }
    
    public static Assignment byId(String id) {
        return template.exchange(endpoint + id, HttpMethod.GET, 
                new HttpEntity<>(null, credentials()), 
                Assignment.class).getBody();
    }
}
