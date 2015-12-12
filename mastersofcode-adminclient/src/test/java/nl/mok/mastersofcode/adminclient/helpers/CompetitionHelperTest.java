package nl.mok.mastersofcode.adminclient.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import remote.ws.mok.domain.Competition;
import remote.ws.mok.domain.Round;
import remote.ws.mok.domain.User;

/**
 *
 * @author Robert
 */
public class CompetitionHelperTest {
    
    public CompetitionHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of addUser method, of class CompetitionHelper.
     */
    @org.junit.Test
    public void testAddUser() {
        Competition competition = new Competition();
        User user = new User();
        
        competition.setTeams(new ArrayList<>());
        
        CompetitionHelper.addUser(competition, user);
        
        assertTrue(competition.getTeams().contains(user));
    }

    /**
     * Test of setRounds method, of class CompetitionHelper.
     */
    @org.junit.Test
    public void testSetRounds() {
        Round a = new Round(), b = new Round(), c = new Round(), 
                d = new Round();
        
        Competition competition = new Competition();
        
        List<Round> rounds = Arrays.asList(a, b, c, d);
        
        CompetitionHelper.setRounds(competition, rounds);
        
        Stream.of(a, b, c, d).forEach(r -> 
                assertTrue(competition.getRounds().contains(r)));
    }
    
}
