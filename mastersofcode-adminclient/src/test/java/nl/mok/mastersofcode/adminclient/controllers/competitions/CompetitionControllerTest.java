package nl.mok.mastersofcode.adminclient.controllers.competitions;

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
import remote.ws.mok.domain.Competition;
import remote.ws.mok.endpoint.AuthenticatedSession;
import remote.ws.mok.endpoint.CompetitionService;

/**
 *
 * @author Robert
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest( { AuthenticatedSession.class, CompetitionService.class } )
public class CompetitionControllerTest {

    private HttpServletRequest mockRequest;
    
    public CompetitionControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mockRequest = Mockito.mock(HttpServletRequest.class);
        Mockito.when(mockRequest.getRequestURL()).
                thenReturn(new StringBuffer(""));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of showCompetitions method, of class CompetitionController.
     */
    @Test
    public void testShowCompetitions() {
        List<Competition> competitions = Arrays.asList(new Competition(), 
                new Competition(), new Competition());
        
        PowerMockito.mockStatic(CompetitionService.class);
        PowerMockito.when(CompetitionService.all()).thenReturn(competitions);
        
        List<Competition> result = (List<Competition>) 
                new CompetitionController().showCompetitions(mockRequest).
                        getModel().get("competitions");
        
        assertEquals("Competitions not in model.", competitions, result);
    }
}