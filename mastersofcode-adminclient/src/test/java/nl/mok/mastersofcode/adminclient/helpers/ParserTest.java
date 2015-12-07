package nl.mok.mastersofcode.adminclient.helpers;

import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Robert
 */
public class ParserTest {
    
    public ParserTest() {
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
     * Test of parseInt method, of class Parser.
     */
    @Test
    public void testParseInt() {
        String a = "1", b = "120", c = "-01", d = "a9", e = "0,1", f = "1.0";
        
        Stream.of(a, b, c).map(s -> Parser.parseInt(s)).
                forEach(i -> assertTrue(i.isPresent()));
        
        Stream.of(d, e, f).map(s -> Parser.parseInt(s)).
                forEach(i -> assertFalse(i.isPresent()));
    }
    
}
