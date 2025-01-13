package petstore.Tests;

import org.junit.jupiter.api.Test;
import petstore.TestModel.PetTestModel;

public class UpdatePetTests {

    @Test
    public void updatePetPositive(){
        PetTestModel newPet = new PetTestModel("557","Morsik", "available", "https://cdn.pet911.ru/169398719364f83179b48965.99590080_EB2CF68622344E14AE5BD8B73257FA0D.webp",
                "2", "Pet", "2","scottish", 200);
        newPet.updatePet();
    }

    @Test
    public void updatePetNegativeInvalidPetId(){
        PetTestModel newPet = new PetTestModel("One","Morsik", "available", "https://cdn.pet911.ru/169398719364f83179b48965.99590080_EB2CF68622344E14AE5BD8B73257FA0D.webp",
                "2", "Pet", "3","scottish", 400);
        newPet.updatePet();
    }

    @Test
    public void updatePetNegativeInvalidCategoryId(){
        PetTestModel newPet = new PetTestModel("1","Morsik", "available", "https://cdn.pet911.ru/169398719364f83179b48965.99590080_EB2CF68622344E14AE5BD8B73257FA0D.webp",
                "Two", "Pet", "3","scottish", 500);
        newPet.updatePet();
    }

    @Test
    public void updatePetNegativeTagId(){
        PetTestModel newPet = new PetTestModel("1","Morsik", "available", "https://cdn.pet911.ru/169398719364f83179b48965.99590080_EB2CF68622344E14AE5BD8B73257FA0D.webp",
                "2", "Pet", "Three","scottish", 500);
        newPet.updatePet();
    }


}
