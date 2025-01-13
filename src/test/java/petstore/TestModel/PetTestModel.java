package petstore.TestModel;

import io.restassured.http.ContentType;
import petstore.TestBase;


import static io.restassured.RestAssured.given;

public class PetTestModel extends TestBase {

    private String endPoint = "/pet";

    private String petId;
    private String petName;
    private String petStatus;
    private String photoPet;

    private String categoryId;
    private String categoryName;

    private String tagId;
    private String tagName;

    private int statusCode;

    public PetTestModel(int statusCode){
        this.statusCode = statusCode;
    }

    public PetTestModel(String categoryName, int statusCode){
        this.categoryName = categoryName;
        this.statusCode = statusCode;
    }

    public PetTestModel(int statusCode, String petId){
        this.petId = petId;
        this.statusCode = statusCode;
    }

    public PetTestModel(String petId,
                        String petName,
                        String petStatus,
                        String photoPet,
                        String categoryId,
                        String categoryName,
                        String tagId,
                        String tagName,
                        int statusCode){
        this.petId = petId;
        this.petName = petName;
        this.petStatus = petStatus;
        this.photoPet = photoPet;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.tagId = tagId;
        this.tagName = tagName;
        this.statusCode = statusCode;
    }


    public void addNewPet() {
        given()
               .baseUri(baseUrI)
               .basePath(endPoint)
               .contentType(ContentType.JSON)
               .body("{\n" +
                        "\"id\": " + petId + ",\n" +
                        "\"category\": \n" +
                        "{\n" +
                        "\"id\": " + categoryId + ",\n" +
                        "\"name\": \"" + categoryName + "\"\n" +
                        "\t},\n" +
                        "\"name\": \"" + petName + "\",\n" +
                        "\"photoUrls\": [\"" + photoPet + "\"],\n" +
                        "\"tags\": [{\n" +
                        "\"id\": " + tagId + ",\n" +
                        "\"name\": \"" + tagName + "\"\n" +
                        "}],\n" +
                        "\"status\": \"" + petStatus + "\"\n" +
                        "}").
        when()
               .post().
        then()
                .statusCode(statusCode)
                .log()
                .all();
    }

    public void updatePet(){
        given()
                .baseUri(baseUrI)
                .basePath(endPoint)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"id\": " + petId + ",\n" +
                        "\"category\": \n" +
                        "{\n" +
                        "\"id\": " + categoryId + ",\n" +
                        "\"name\": \"" + categoryName + "\"\n" +
                        "\t},\n" +
                        "\"name\": \"" + petName + "\",\n" +
                        "\"photoUrls\": [\"" + photoPet + "\"],\n" +
                        "\"tags\": [{\n" +
                        "\"id\": " + tagId + ",\n" +
                        "\"name\": \"" + tagName + "\"\n" +
                        "}],\n" +
                        "\"status\": \"" + petStatus + "\"\n" +
                        "}").
                when()
                .put().
                then()
                .statusCode(statusCode)
                .log()
                .all();
    }

    public void getPetByStatus(){
        given()
                .baseUri(baseUrI)
                .basePath(endPoint + "/findByStatus")
                .queryParam("status",categoryName).
                when()
                .get().
                then()
                .statusCode(statusCode)
                .log()
                .all();
    }

    public void getPetById(){
        given()
                .baseUri(baseUrI)
                .basePath(endPoint + "/" + petId).
                when()
                .get().
                then()
                .statusCode(statusCode)
                .log()
                .all();
    }

    public void deletePetById(){
        given()
                .baseUri(baseUrI)
                .basePath(endPoint + "/" + petId).
                when()
                .delete().
                then()
                .statusCode(statusCode)
                .log()
                .all();
    }
}
