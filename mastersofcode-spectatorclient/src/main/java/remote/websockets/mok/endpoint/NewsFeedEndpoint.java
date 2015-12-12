package remote.websockets.mok.endpoint;

import java.io.IOException;
import java.net.URI;
import java.util.function.Consumer;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;

/**
 *
 * @author Robert
 */
@ClientEndpoint
public class NewsFeedEndpoint {
    
    private final Consumer<String> consumer;
    
    public NewsFeedEndpoint(Consumer<String> consumer) {
        this.consumer = consumer;
        
        try {
            ContainerProvider.getWebSocketContainer().
                    connectToServer(NewsFeedEndpoint.class, 
                            URI.create("ws://localhost:8083/newsfeed"));
        } catch (DeploymentException | IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @OnMessage
    public void onMessage(String message) {
        consumer.accept(message);
    }
}
