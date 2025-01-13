package petstore.Tests;

import org.junit.jupiter.api.Test;
import petstore.TestModel.PetTestModel;


public class AddPetTests {


    @Test
    public void addPetPositiveTest(){
        PetTestModel newPet = new PetTestModel("557","Murzik", "available", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVP9Djxpuw_qRotEFSzIOMv8k6S9VmO2Hyfw&s",
                "1", "Cat", "1","british", 200);
        newPet.addNewPet();
    }

    @Test
    public void addPetPositiveTest_2(){
        PetTestModel newPet = new PetTestModel("558","Барсик", "Продан", "привет",
                "1", "Категория", "1","Тег", 200);
        newPet.addNewPet();
    }

    @Test
    public void addPetPositiveTest_3(){
        PetTestModel newPet = new PetTestModel(200);
        newPet.addNewPet();
    }
    @Test
    public void addPetNegativeTestInvalidPetId(){
        PetTestModel newPet = new PetTestModel("One","11", "sold", "URL",
                "2", "Cat", "3","name", 400);
        newPet.addNewPet();
    }
    @Test
    public void addPetNegativeTestInvalidCategoryId(){
        PetTestModel newPet = new PetTestModel("1","11", "sold", "URL",
                "Two", "Cat", "3","name", 500);
        newPet.addNewPet();
    }
    @Test
    public void addPetNegativeTestInvalidTagId(){
        PetTestModel newPet = new PetTestModel("1","11", "sold", "URL",
                "2", "Cat", "Three","name", 500);
        newPet.addNewPet();
    }



}
