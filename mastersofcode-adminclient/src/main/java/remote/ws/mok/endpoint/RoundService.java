package remote.ws.mok.endpoint;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import remote.ws.mok.domain.Round;
import static remote.ws.mok.endpoint.AuthenticatedSession.credentials;

/**
 *
 * @author Robert
 */
public class RoundService extends AuthenticatedSession {

    private final static String endpoint = "http://localhost:8083/api/rounds/";
    private final static RestTemplate template = new RestTemplate();

    public static List<Round> all() {
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Round[].class).getBody());
    }

    public static Round current() {
        return template.exchange(endpoint + "current", HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Round.class).getBody();
    }

    public static void add(Round round) {
        template.exchange(endpoint, HttpMethod.POST,
                new HttpEntity<>(round, credentials()), String.class);
    }

    public static void update(Round round) {
        template.exchange(endpoint, HttpMethod.PUT,
                new HttpEntity<>(round, credentials()), String.class);
    }

    public static void delete(Round round) {
        template.exchange(endpoint, HttpMethod.PUT,
                new HttpEntity<>(round, credentials()), String.class);
    }

    public static Round byId(int id) {
        return template.exchange(endpoint + id, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Round.class).getBody();
    }

    public static boolean start(String id) {
        return template.exchange(endpoint + "current", HttpMethod.POST,
                new HttpEntity<>(id, credentials()), boolean.class).getBody();
    }
}
