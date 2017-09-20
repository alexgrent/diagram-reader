package org.reactome.server.tools.diagram.data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.reactome.server.tools.diagram.data.exception.DeserializationException;
import org.reactome.server.tools.diagram.data.graph.Graph;
import org.reactome.server.tools.diagram.data.layout.Diagram;
import org.reactome.server.tools.diagram.data.profile.DiagramProfile;
import sun.misc.IOUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Unit testing.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest extends TestCase {

    private static String BASE_URL = "http://www.reactome.org/download/current/diagram/";
    private static String DIAGRAM_ID = "R-HSA-186712"; //Stable Id or DBId
    private static String SUFFIX = ".json";
    private static String MODERN_PROFILE = "Modern";
    private static String STANDARD_PROFILE = "Standard";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Diagram Test :-)
     */
    public void testDiagram()
    {
        String url = BASE_URL + DIAGRAM_ID + SUFFIX;
        try {
            String json = readFromURL(url);
            Diagram diagram = DiagramFactory.getDiagram(json);
            assertNotNull(diagram);
            assertEquals(DIAGRAM_ID, diagram.getStableId());
            System.out.println("Testing diagram[" + DIAGRAM_ID + "] ... OK");
        } catch (IOException e) {
            fail("Could not retrieve diagram from: " + url);
        } catch (DeserializationException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Graph Test :-)
     */
    public void testGraph()
    {
        String url = BASE_URL + DIAGRAM_ID + ".graph" + SUFFIX;
        try {
            String json = readFromURL(url);
            Graph graph = DiagramFactory.getGraph(json);
            assertNotNull(graph);
            System.out.println("Testing graph[" + DIAGRAM_ID + "] ... OK");
        } catch (IOException e) {
            fail("Could not retrieve graph from: " + url);
        } catch (DeserializationException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Profile Test :-)
     */
    public void testProfile()
    {
        String profileName = MODERN_PROFILE + ".json";
        try {
            String json = readFile(profileName);
            DiagramProfile profile = DiagramFactory.getProfile(json);
            assertNotNull(profile);
            assertEquals(MODERN_PROFILE, profile.getName());
            System.out.println("Testing profile[" + profileName + "] ... OK");
        } catch (IOException e) {
            fail("Could not retrieve profile: " + profileName);
        } catch (DeserializationException e) {
            e.printStackTrace();
            fail();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            fail();
        }
    }

    private static String readFromURL(String url) throws IOException {
        InputStream in = new URL(url).openStream();
        return new String(IOUtils.readFully(in, -1, true));
    }

    private static String readFile(String filename) throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(Paths.get(AppTest.class.getResource(filename).toURI())));
    }
}