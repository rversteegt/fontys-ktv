package nl.mok.mastersofcode.adminclient.helpers;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import remote.ws.mok.domain.Member;
import remote.ws.mok.domain.User;

/**
 *
 * @author Robert
 */
public class UserHelperTest {
    
    public UserHelperTest() {
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
     * Test of addMember method, of class UserHelper.
     */
    @Test
    public void testAddMember() {
        Member a = new Member(), b = new Member(), c = new Member(), 
                d = new Member();
        User user = new User();
        user.setMembers(new ArrayList<>());
        
        Stream.of(a, b, c, d).forEach(m -> UserHelper.addMember(user, m));
        
        Stream.of(a, b, c, d).forEach(m -> 
                assertTrue(user.getMembers().contains(m)));
    }
    
}
