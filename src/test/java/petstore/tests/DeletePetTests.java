package petstore.tests;


import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import petstore.api.PetApi;

public class DeletePetTests {

    @Test
    public void deletePetPositive() {
        Response response = new PetApi().deletePetById("557");

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void deletePetSecondDelete() {
        Response response = new PetApi().deletePetById("557");

        response.then()
                .statusCode(404)
                .log()
                .all();
    }

    @Test
    public void deletePetNegativeTest() {
        Response response = new PetApi().deletePetById("999999999993");

        response.then()
                .statusCode(404)
                .log()
                .all();
    }

    @Test
    public void deletePetNegativeInvalidValue() {
        Response response = new PetApi().deletePetById("one");

        response.then()
                .statusCode(404)
                .log()
                .all();
    }
}
