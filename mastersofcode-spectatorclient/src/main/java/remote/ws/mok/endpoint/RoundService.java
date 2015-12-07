package remote.ws.mok.endpoint;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import remote.ws.mok.domain.Round;

/**
 *
 * @author Robert
 */
public class RoundService extends AuthenticatedSession {

    private final static String endpoint = "http://localhost:8083/api/rounds/";
    private final static RestTemplate template = new RestTemplate();

    public static List<Round> all() {
        login();
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Round[].class).getBody());
    }

    public static Round byId(int id) {
        login();
        return template.exchange(endpoint + id, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Round.class).getBody();
    }

    public static Round current() {
        login();
        return template.exchange(endpoint + "current", HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Round.class).getBody();
    }
}
