package petstore.Tests;

import org.junit.jupiter.api.Test;
import petstore.TestModel.PetTestModel;

public class FindPetTests {



    @Test
    public void findPetByStatusAvailable(){
        PetTestModel newPet = new PetTestModel("available", 200);
        newPet.getPetByStatus();
    }

    @Test
    public void findPetByStatusPending(){
        PetTestModel newPet = new PetTestModel("pending", 200);
        newPet.getPetByStatus();
    }

    @Test
    public void findPetByStatusSold(){
        PetTestModel newPet = new PetTestModel("sold", 200);
        newPet.getPetByStatus();
    }

    @Test
    public void findPetByIdPositive(){
        PetTestModel newPet = new PetTestModel(200, "557");
        newPet.getPetById();
    }

    @Test
    public void findPetByIdNegative(){
        PetTestModel newPet = new PetTestModel(404, "999999999967");
        newPet.getPetById();
    }

    @Test
    public void findPetByIdNegativeInvalidValue(){
        PetTestModel newPet = new PetTestModel(404, "One");
        newPet.getPetById();
    }
}
