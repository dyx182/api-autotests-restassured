package petstore.api;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petstore.models.Pet;

import static io.restassured.RestAssured.given;



public class PetApi {

    private static final Gson gson = new Gson();

    public Response addPet(Pet pet, String url, String endpoint) {
        String petJson = gson.toJson(pet);
        return given()
                .baseUri(url)
                .contentType(ContentType.JSON)
                .body(petJson)
                .when()
                .post(endpoint);
    }

    public Response updatePet(Pet pet, String url, String endpoint) {
        String petJson = gson.toJson(pet);
        return given()
                .baseUri(url)
                .contentType(ContentType.JSON)
                .body(petJson)
                .when()
                .put(endpoint);
    }

    public Response getPetByStatus(String value, String url, String endpoint) {
        return given()
                .baseUri(url)
                .queryParam("status", value)
                .when()
                .get(endpoint);
    }

    public Response getPetById(String value, String url, String endpoint) {
        return given()
                .baseUri(url)
                .pathParam("petId", value)
                .when()
                .get(endpoint);
    }

    public Response deletePetById(String value, String url, String endpoint) {
        return given()
                .baseUri(url)
                .pathParam("petId", value)
                .when()
                .delete(endpoint);
    }
}
