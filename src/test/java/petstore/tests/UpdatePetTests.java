package petstore.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import petstore.api.PetApi;
import petstore.models.Category;
import petstore.models.Pet;
import petstore.models.Tags;

import java.util.Arrays;
import java.util.List;

import static petstore.api.ApiConstants.*;


public class UpdatePetTests {

    @Test
    public void updatePetPositive() {
        Category category = new Category("557", "scottish");
        Tags tag = new Tags("2", "Pet");
        List<String> photoUrls = Arrays.asList("https://cdn.pet911.ru/169398719364f83179b48965.99590080_EB2CF68622344E14AE5BD8B73257FA0D.webp");
        List<Tags> tags = Arrays.asList(tag);

        Pet pet = new Pet("557", category, "Murxik", photoUrls, tags, "available");
        Response response = new PetApi().updatePet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void updatePetHTTPTest() {
        Category category = new Category("557", "scottish");
        Tags tag = new Tags("2", "Pet");
        List<String> photoUrls = Arrays.asList("https://cdn.pet911.ru/169398719364f83179b48965.99590080_EB2CF68622344E14AE5BD8B73257FA0D.webp");
        List<Tags> tags = Arrays.asList(tag);

        Pet pet = new Pet("557", category, "Murxik", photoUrls, tags, "available");
        Response response = new PetApi().updatePet(pet, BASE_URL_80, ENDPOINT_PET);

        response.then()
                .statusCode(301)
                .log()
                .all();
    }

    @Test
    public void updatePetInvalidPetId() {
        Category category = new Category("557", "scottish");
        Tags tag = new Tags("2", "Pet");
        List<String> photoUrls = Arrays.asList("https://cdn.pet911.ru/169398719364f83179b48965.99590080_EB2CF68622344E14AE5BD8B73257FA0D.webp");
        List<Tags> tags = Arrays.asList(tag);

        Pet pet = new Pet("one", category, "Murxik", photoUrls, tags, "available");
        Response response = new PetApi().updatePet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(500)
                .log()
                .all();
    }

    @Test
    public void updatePetInvalidCategoryId() {
        Category category = new Category("two", "scottish");
        Tags tag = new Tags("2", "Pet");
        List<String> photoUrls = Arrays.asList("https://cdn.pet911.ru/169398719364f83179b48965.99590080_EB2CF68622344E14AE5BD8B73257FA0D.webp");
        List<Tags> tags = Arrays.asList(tag);

        Pet pet = new Pet("2", category, "Murxik", photoUrls, tags, "available");
        Response response = new PetApi().updatePet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(500)
                .log()
                .all();
    }

    @Test
    public void updatePetInvalidTagId() {
        Category category = new Category("2", "scottish");
        Tags tag = new Tags("Three", "Pet");
        List<String> photoUrls = Arrays.asList("https://cdn.pet911.ru/169398719364f83179b48965.99590080_EB2CF68622344E14AE5BD8B73257FA0D.webp");
        List<Tags> tags = Arrays.asList(tag);

        Pet pet = new Pet("2", category, "Murxik", photoUrls, tags, "available");
        Response response = new PetApi().updatePet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(500)
                .log()
                .all();
    }
}
