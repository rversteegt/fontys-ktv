/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.mok.mastersofcode.adminclient.helpers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
