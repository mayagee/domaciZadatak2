package test.suites;

import calls.CrocodilesAPI;
import common.RestAssuredFunctions;
import data.models.*;
import io.restassured.response.Response;
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
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Mila", "M", "2020-12-12");
        SingleCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);
        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, createCrocodileRequest);
    }

    @Test
    public void getListOfPublicCrocodiles() {
        CrocodileResponse[] crocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();
        crocodileAsserts.assertListOfPublicCrocodiles(crocodileResponse);
    }

    @Test
    public void getListOfMyCrocodiles() {
        CrocodileResponse[] crocodileResponse = CrocodilesAPI.getMyCrocodileResponses(accessToken);
        crocodileAsserts.assertListOfMyCrocodiles(crocodileResponse);
    }

    @Test
    public void getCrocodileById() {
       SingleCrocodileResponse singleCrocodileResponse = CrocodilesAPI.getCrocodileByIdResponse(accessToken);
        crocodileAsserts.assertNewCrocodile(singleCrocodileResponse);
    }

    @Test
    public void  deleteMyCrocodile(){
        SingleCrocodileResponse singleCrocodileResponse = CrocodilesAPI.deleteMyCrocodile(accessToken);
        crocodileAsserts.assertDeleteSingleCrocodile(singleCrocodileResponse);
  }

    @Test
    @Description("Update a single private crocodile with Patch")
    public void patchCrocodile() {
        SingleCrocodileResponse singleCrocodileResponse = CrocodilesAPI.getCrocodileByIdResponse(accessToken);
        singleCrocodileResponse.setName("Darija");
        SingleCrocodileResponse patchCrocodileResponse = CrocodilesAPI.patchCrocodile(accessToken,singleCrocodileResponse);
        crocodileAsserts.assertPatchMyCrocodile(patchCrocodileResponse, singleCrocodileResponse);
    }


    @Test
    public void updateCrocodile() {
        SingleCrocodileResponse singleCrocodileResponse = CrocodilesAPI.getCrocodileByIdResponse(accessToken);
        singleCrocodileResponse.setName("Jasmina");
        singleCrocodileResponse.setAge(2);
        singleCrocodileResponse.setSex("F");
        singleCrocodileResponse.setDateOfBirth("2020-21-10");
        SingleCrocodileResponse updateCrocodileResponse = CrocodilesAPI.updateCrocodile(accessToken,singleCrocodileResponse);
        crocodileAsserts.assertUpdateMyCrocodile(updateCrocodileResponse, singleCrocodileResponse);
    }



}
