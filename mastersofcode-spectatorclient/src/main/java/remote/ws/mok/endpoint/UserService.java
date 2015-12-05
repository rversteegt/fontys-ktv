package remote.ws.mok.endpoint;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import remote.ws.mok.domain.User;
import static remote.ws.mok.endpoint.AuthenticatedSession.credentials;

/**
 *
 * @author Robert
 */
public class UserService extends AuthenticatedSession {

    private final static String endpoint = "http://localhost:8083/api/users/";
    private final static RestTemplate template = new RestTemplate();

    public static List<User> all() {
        AuthenticatedSession.login();
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                User[].class).getBody());
    }
    
    public static List<User> allOfRole(String role) {
        AuthenticatedSession.login();
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                User[].class).getBody()).stream()
                .filter(t->t.getRole().equals(role))
                .collect(toList());
    }

    public static User byId(String username) {
        AuthenticatedSession.login();
        return template.exchange(endpoint + username, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                User.class).getBody();
    }

}
