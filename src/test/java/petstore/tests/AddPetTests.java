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


public class AddPetTests {

    @Test
    public void addPetPositiveTest() {
        Category category = new Category("1", "Cat");
        Tags tag = new Tags("1", "british");
        List<Tags> tags = Arrays.asList(tag);
        List<String> photoUrls = Arrays.asList("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVP9Djxpuw_qRotEFSzIOMv8k6S9VmO2Hyfw&s");

        Pet pet = new Pet("557", category, "Murzik", photoUrls, tags, "available");
        Response response = new PetApi().addPet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void addPetPositiveTest_2() {
        Category category = new Category("1", "Категория");
        Tags tag = new Tags("1","Тег");
        List<Tags> tags = Arrays.asList(tag);
        List<String> photoUrls = Arrays.asList("URL");

        Pet pet = new Pet("558", category, "Барсик", photoUrls, tags, "Sold");
        Response response = new PetApi().addPet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void addPetHTTPTest() {
        Category category = new Category("1", "Категория");
        Tags tag = new Tags("1","Тег");
        List<Tags> tags = Arrays.asList(tag);
        List<String> photoUrls = Arrays.asList("URL");

        Pet pet = new Pet("558", category, "Барсик", photoUrls, tags, "Sold");
        Response response = new PetApi().addPet(pet, BASE_URL_80, ENDPOINT_PET);

        response.then()
                .statusCode(301)
                .log()
                .all();
    }

    @Test
    public void addPetWithTwoTagsAndPhotos() {
        Category category = new Category("1", "Cat");
        Tags tag1 = new Tags("1", "british");
        Tags tag2 = new Tags("2", "siberian");
        List<Tags> tags = Arrays.asList(tag1, tag2);
        List<String> photoUrls = Arrays.asList(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9Gc",
                "https://encrypted-tbn0.gstatic.com/iq=tbn:ANpuVmO2Hyfw&s"
        );

        Pet pet = new Pet("557", category, "Murzik", photoUrls, tags, "available");
        Response response = new PetApi().addPet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void addPetInvalidPetId() {
        Category category = new Category("1", "Cat");
        Tags tag = new Tags("1","british");
        List<Tags> tags = Arrays.asList(tag);
        List<String> photoUrls = Arrays.asList("URL");

        Pet pet = new Pet("one", category, "Murzik", photoUrls, tags, "available");
        Response response = new PetApi().addPet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(500)
                .log()
                .all();
    }

    @Test
    public void addPetInvalidCategoryid() {
        Category category = new Category("two", "Категория");
        Tags tag = new Tags("1","Тег");
        List<Tags> tags = Arrays.asList(tag);
        List<String> photoUrls = Arrays.asList("URL");

        Pet pet = new Pet("1", category, "Барсик", photoUrls, tags, "available");
        Response response = new PetApi().addPet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(500)
                .log()
                .all();
    }

    @Test
    public void addPetInvalidTagsid() {
        Category category = new Category("2", "Категория");
        Tags tag = new Tags("Three","Тег");
        List<Tags> tags = Arrays.asList(tag);
        List<String> photoUrls = Arrays.asList("URL");

        Pet pet = new Pet("1", category, "Барсик", photoUrls, tags, "Three");
        Response response = new PetApi().addPet(pet, BASE_URL, ENDPOINT_PET);

        response.then()
                .statusCode(500)
                .log()
                .all();
    }
}
