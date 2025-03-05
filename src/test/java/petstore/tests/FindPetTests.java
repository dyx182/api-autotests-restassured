package petstore.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import petstore.api.PetApi;

import static petstore.api.ApiConstants.*;

public class FindPetTests {


    @Test
    public void findPetByStatusAvailable() {
        Response response = new PetApi().getPetByStatus("available", BASE_URL, ENDPOINT_PET_FIND);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void findPetByStatusSold() {
        Response response = new PetApi().getPetByStatus("Sold", BASE_URL, ENDPOINT_PET_FIND);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void findPetByStatusPending() {
        Response response = new PetApi().getPetByStatus("pending", BASE_URL, ENDPOINT_PET_FIND);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void findPetByStatusHTTPTest() {
        Response response = new PetApi().getPetByStatus("pending", BASE_URL_80, ENDPOINT_PET_FIND);

        response.then()
                .statusCode(200) // bug
                .log()
                .all();
    }

    @Test
    public void findPetByIdPositive() {
        Response response = new PetApi().getPetById("558", BASE_URL, ENDPOINT_PET_ID);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void findPetByIdHTTPTest() {
        Response response = new PetApi().getPetById("558", BASE_URL_80, ENDPOINT_PET_ID);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void findPetByIdNegative() {
        Response response = new PetApi().getPetById("9999999878899", BASE_URL, ENDPOINT_PET_ID);

        response.then()
                .statusCode(404)
                .log()
                .all();
    }
}
