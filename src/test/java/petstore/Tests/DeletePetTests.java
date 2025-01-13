package petstore.Tests;


import org.junit.jupiter.api.Test;
import petstore.TestModel.PetTestModel;

public class DeletePetTests {


    @Test
    public void deletePetPositive(){
        PetTestModel newPet = new PetTestModel(200,"557");
        newPet.deletePetById();
    }

    @Test
    public void deletePetNegativeSecondDelete(){
        PetTestModel newPet = new PetTestModel(404, "999999999889");
        newPet.deletePetById();
    }

    @Test
    public void deletePetNegativeInvalidValues(){
        PetTestModel newPet = new PetTestModel(404, "One");
        newPet.deletePetById();
    }

}
