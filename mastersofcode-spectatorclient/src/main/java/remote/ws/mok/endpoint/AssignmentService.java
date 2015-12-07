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
    private final static String endpoint = "http://localhost:8083/api/assignments/";
    private final static RestTemplate template = new RestTemplate();
    
    public static List<Assignment> all() {
        AuthenticatedSession.login();
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET, 
                new HttpEntity<>(null, credentials()), 
                Assignment[].class).getBody());
    }
    
    public static Assignment byId(String id) {
        AuthenticatedSession.login();
        return template.exchange(endpoint + id, HttpMethod.GET, 
                new HttpEntity<>(null, credentials()), 
                Assignment.class).getBody();
    }
}
