package test.suites;

import calls.CrocodilesAPI;
import data.models.CreateCrocodileRequest;
import data.models.CreateCrocodileResponse;
import data.models.GetPublicCrocodileResponse;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Milan", "M", "2020-12-12");

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, createCrocodileRequest);

    }

    @Test
    @Description("dsds")
    public void getListOfPublicCrocodiles() {
        GetPublicCrocodileResponse[] getPublicCrocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();

        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
    }

}
