package test;

import data.models.CreateCrocodileRequest;
import data.models.CreateCrocodileResponse;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {
    public SoftAssert softAssert;

    public void assertCreateNewCrocodile(CreateCrocodileResponse createCrocodileResponse, CreateCrocodileRequest createCrocodileRequest){

        this.softAssert = new SoftAssert();
        softAssert.assertEquals(createCrocodileResponse.getName(),createCrocodileRequest.getName(),"Name didn't match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "date didn't match");
        softAssert.assertAll();
    }
}
