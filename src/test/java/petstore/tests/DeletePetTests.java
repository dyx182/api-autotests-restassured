package petstore.tests;


import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import petstore.api.PetApi;

import static petstore.api.ApiConstants.*;

public class DeletePetTests {

    @Test
    public void deletePetPositive() {
        Response response = new PetApi().deletePetById("557", BASE_URL, ENDPOINT_PET_ID);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void deletePetSecondDelete() {
        Response response = new PetApi().deletePetById("557", BASE_URL, ENDPOINT_PET_ID);

        response.then()
                .statusCode(404)
                .log()
                .all();
    }

    @Test
    public void deletePetHTTPTest() {
        Response response = new PetApi().deletePetById("557", BASE_URL_80, ENDPOINT_PET_ID);

        response.then()
                .statusCode(301)
                .log()
                .all();
    }

    @Test
    public void deletePetNegativeTest() {
        Response response = new PetApi().deletePetById("999999999993", BASE_URL, ENDPOINT_PET_ID);

        response.then()
                .statusCode(404)
                .log()
                .all();
    }

    @Test
    public void deletePetNegativeInvalidValue() {
        Response response = new PetApi().deletePetById("one", BASE_URL, ENDPOINT_PET_ID);

        response.then()
                .statusCode(404)
                .log()
                .all();
    }
}
