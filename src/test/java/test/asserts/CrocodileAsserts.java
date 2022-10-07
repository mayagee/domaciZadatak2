package test.asserts;

import data.models.CreateCrocodileRequest;
import data.models.CreateCrocodileResponse;
import data.models.GetPublicCrocodileResponse;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();;

    public void assertCreateNewCrocodile(CreateCrocodileResponse createCrocodileResponse, CreateCrocodileRequest createCrocodileRequest) {
        softAssert.assertEquals(createCrocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "date of birth didn't match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfPublicCrocodiles(GetPublicCrocodileResponse[] getPublicCrocodileResponse) {
        for(int i = 0; i < getPublicCrocodileResponse.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponse[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }
}
