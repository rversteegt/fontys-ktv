package nl.mok.mastersofcode.adminclient.controllers.teams;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import remote.ws.mok.domain.User;
import remote.ws.mok.endpoint.AuthenticatedSession;
import remote.ws.mok.endpoint.UserService;

/**
 *
 * @author Robert
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest( { AuthenticatedSession.class, UserService.class } )
public class TeamControllerTest {
    
    private HttpServletRequest mockRequest;
    
    public TeamControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        PowerMockito.mockStatic(AuthenticatedSession.class, i -> null);
        
        mockRequest = Mockito.mock(HttpServletRequest.class);
        Mockito.when(mockRequest.getRequestURL()).
                thenReturn(new StringBuffer(""));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of showUsers method, of class TeamController.
     */
    @Test
    public void testShowUsers() {
        final List<User> users = Arrays.asList(new User(), new User());
        
        PowerMockito.mockStatic(UserService.class);
        PowerMockito.when(UserService.allOfRole("team")).thenReturn(users);
        
        List<User> result = (List<User>) new TeamController().
                showUsers(mockRequest).getModel().get("teams");
        
        assertEquals("Model does not contain users.", users, result);
    }

    /**
     * Test of showUser method, of class TeamController.
     */
    @Test
    public void testShowUser() {
        final User user = new User();
        
        PowerMockito.mockStatic(UserService.class);
        PowerMockito.when(UserService.byId("1234")).thenReturn(user);
        
        User result = (User) new TeamController().
                showUser(mockRequest, "1234").getModel().get("team");
        
        assertEquals("Model does not contain user.", user, result);        
    }
}
