package petstore.api;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petstore.models.Pet;

import static io.restassured.RestAssured.given;

public class PetApi {

    public static final String BASEURI = "https://petstore.swagger.io/v2";
    public static final String ENDPOINT_PET = "/pet";
    private static final Gson gson = new Gson();

    public Response addPet(Pet pet) {
        String petJson = gson.toJson(pet);
        return given()
                .baseUri(BASEURI)
                .contentType(ContentType.JSON)
                .body(petJson)
                .when()
                .post(ENDPOINT_PET);
    }

    public Response updatePet(Pet pet) {
        String petJson = gson.toJson(pet);
        return given()
                .baseUri(BASEURI)
                .contentType(ContentType.JSON)
                .body(petJson)
                .when()
                .put(ENDPOINT_PET);
    }

    public Response getPetByStatus(String value) {
        return given()
                .baseUri(BASEURI)
                .queryParam("status", value)
                .when()
                .get(ENDPOINT_PET + "/findByStatus");
    }

    public Response getPetById(String value) {
        return given()
                .baseUri(BASEURI)
                .pathParam("petId", value)
                .when()
                .get(ENDPOINT_PET + "/{petId}");
    }

    public Response deletePetById(String value) {
        return given()
                .baseUri(BASEURI)
                .pathParam("petId", value)
                .when()
                .delete(ENDPOINT_PET + "/{petId}");
    }
}
