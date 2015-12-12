package remote.ws.mok.endpoint;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import remote.ws.mok.domain.Competition;
import static remote.ws.mok.endpoint.AuthenticatedSession.credentials;

/**
 *
 * @author Robert
 */
public class CompetitionService extends AuthenticatedSession {

    private final static String endpoint = "http://localhost:8083/api/competitions/";
    private final static RestTemplate template = new RestTemplate();

    public static List<Competition> all() {
        login();
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Competition[].class).getBody());
    }

    public static Competition byId(int id) {
        login();
        return template.exchange(endpoint + id, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Competition.class).getBody();
    }

    public static Competition current() {
        login();
        return template.exchange(endpoint + "current", HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Competition.class).getBody();
    }

    public static boolean start(String id) {
        login();
        return template.exchange(endpoint + "current", HttpMethod.POST,
                new HttpEntity<>(null, credentials()),
                boolean.class).getBody();
    }
    
}
