package petstore.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import petstore.api.PetApi;

public class FindPetTests {


    @Test
    public void findPetByStatusAvailable() {
        Response response = new PetApi().getPetByStatus("available");

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void findPetByStatusSold() {
        Response response = new PetApi().getPetByStatus("Sold");

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void findPetByStatusPending() {
        Response response = new PetApi().getPetByStatus("pending");

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void findPetByIdPositive() {
        Response response = new PetApi().getPetById("558");

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void findPetByIdNegative() {
        Response response = new PetApi().getPetById("9999999878899");

        response.then()
                .statusCode(404)
                .log()
                .all();
    }
}
