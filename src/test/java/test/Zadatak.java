package test;

import calls.CrocodilesAPI;
import data.models.LoginRequest;
import data.models.LoginResponse;

public class Zadatak {

    public static void main(String[] args) {

      // setBaseURL("http://test-api.k6.io");

        LoginRequest loginRequest = new LoginRequest("Maja22", "QA2022");
        LoginResponse loginResponse = CrocodilesAPI.login(loginRequest);

        loginResponse.getAccess();


    }
}
