package remote.ws.mok.endpoint;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import remote.ws.mok.domain.User;

/**
 *
 * @author Robert
 */
public class UserService extends AuthenticatedSession {
    private final static String endpoint = "http://localhost:8083/api/users/";
    private final static RestTemplate template = new RestTemplate();
    
    public static List<User> all() {
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET, 
                new HttpEntity<>(null, credentials()), 
                User[].class).getBody());
    }
}
