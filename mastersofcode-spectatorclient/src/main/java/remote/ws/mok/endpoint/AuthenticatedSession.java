package remote.ws.mok.endpoint;

import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Robert
 */
public class AuthenticatedSession {
    protected static List<String> cookie;
    
    private final static String endpoint = "http://localhost:8083/api/security/guest";
    private final static RestTemplate template = new RestTemplate();
    
    public static void login() {        
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "text/plain");
        HttpEntity request = 
                new HttpEntity(requestHeaders);
         
        HttpEntity<String> response = template.exchange(endpoint, 
                HttpMethod.GET, request, String.class);
       
        cookie = response.getHeaders().get("Set-Cookie");
    }
    
    protected static HttpHeaders credentials() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Cookie", cookie.get(0));
        
        return requestHeaders;
    }
}
