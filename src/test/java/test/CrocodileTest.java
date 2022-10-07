package test;

import calls.CrocodilesAPI;
import data.models.CreateCrocodileRequest;
import data.models.CreateCrocodileResponse;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.common.TestBase;

public class CrocodileTest extends TestBase {

    @Test
    public void loginTest(){

        Assert.assertFalse(accessToken.isEmpty(),"Access token is empty");
    }

    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest(){

        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Mila","F","1987-09-09");

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken,createCrocodileRequest);

     CrocodileAsserts crocodileAsserts = new CrocodileAsserts();
     crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse,createCrocodileRequest);
    }

}
