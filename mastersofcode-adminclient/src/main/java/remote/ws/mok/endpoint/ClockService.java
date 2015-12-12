package remote.ws.mok.endpoint;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import remote.ws.mok.domain.Competition;
import static remote.ws.mok.endpoint.AuthenticatedSession.credentials;

/**
 *
 * @author Robert
 */
public class ClockService extends AuthenticatedSession {

    private final static String endpoint = "http://localhost:8083/api/time/";
    private final static RestTemplate template = new RestTemplate();

    public static void pauseOrResume() {
        template.exchange(endpoint + "pause", HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                String.class);
    }

    public static void freeze() {
        template.exchange(endpoint + "freeze", HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                String.class);
    }

    public static void stop() {
        template.exchange(endpoint + "stop", HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                String.class);
    }
}
