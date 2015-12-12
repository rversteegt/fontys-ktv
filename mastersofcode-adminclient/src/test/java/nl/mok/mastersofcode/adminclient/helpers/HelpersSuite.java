package nl.mok.mastersofcode.adminclient.helpers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Robert
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({UserHelperTest.class, CompetitionHelperTest.class, 
    ParserTest.class})
public class HelpersSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
