package remote.ws.mok.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CompetitionService extends AuthenticatedSession {

    private final static String endpoint = "http://localhost:8083/api/competitions/";
    private final static RestTemplate template = new RestTemplate();

    public static List<Competition> all() {
        AuthenticatedSession.login();
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Competition[].class).getBody());
    }

    public static Competition byId(int id) {
        AuthenticatedSession.login();
        return template.exchange(endpoint + id, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Competition.class).getBody();
    }

    public static Competition current() {
        AuthenticatedSession.login();
        return template.exchange(endpoint + "current", HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Competition.class).getBody();
    }

}