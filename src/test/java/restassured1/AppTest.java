package restassured1;

import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertTrue( true );
        RestAssured.given();
    }
}
