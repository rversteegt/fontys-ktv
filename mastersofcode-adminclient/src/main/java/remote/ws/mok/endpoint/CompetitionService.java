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
public class CompetitionService extends AuthenticatedSession {

    private final static String endpoint = "http://localhost:8083/api/competitions/";
    private final static RestTemplate template = new RestTemplate();

    public static List<Competition> all() {
        return Arrays.asList(template.exchange(endpoint, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Competition[].class).getBody());
    }

    public static void add(Competition competition) {
        template.exchange(endpoint, HttpMethod.POST,
                new HttpEntity<>(competition, credentials()), String.class);
    }

    public static void update(Competition competition) {
        try{
        template.exchange(endpoint, HttpMethod.PUT,
                new HttpEntity<>(competition, credentials()), String.class);
        } catch (HttpClientErrorException ex){
            System.out.println(ex.getResponseBodyAsString());
        }
    }

    public static Competition byId(int id) {
        return template.exchange(endpoint + id, HttpMethod.GET,
                new HttpEntity<>(null, credentials()),
                Competition.class).getBody();
    }
}
