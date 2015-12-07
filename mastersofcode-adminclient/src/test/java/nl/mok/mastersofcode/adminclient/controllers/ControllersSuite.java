package nl.mok.mastersofcode.adminclient.controllers;

import nl.mok.mastersofcode.adminclient.controllers.competitions.CompetitionControllerTest;
import nl.mok.mastersofcode.adminclient.controllers.teams.TeamControllerTest;
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
@Suite.SuiteClasses({CompetitionControllerTest.class, TeamControllerTest.class})
public class ControllersSuite {

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
