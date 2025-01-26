package restassured1;

//import static org.junit.Assert.assertTrue;

import io.restassured.RestAssured;

//import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        RestAssured.given().contentType(null);
    }
}
