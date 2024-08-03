package tests;

import client.BaseClient;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import swagger.petStore.enums.FilePaths;
import swagger.petStore.pojo.pet.Pet;

import java.util.List;

import static swagger.petStore.helpers.DataReader.deserializeJSONToList;
import static swagger.petStore.helpers.DataReader.readUrlListFromJson;

public class AvailablePetTest extends BaseClient {


    @DataProvider(name = "petCreate")
    public Object[][] petCreate() {
        return new Object[][]{
                {123, "Rox", 12, "Dogs", readUrlListFromJson(FilePaths.URLS, "urlPositive"),
                        deserializeJSONToList(FilePaths.TAGS, Pet.Tag.class), "Bldo" },
                {134, "Rox", 11, "BigDogs", readUrlListFromJson(FilePaths.URLS, "urlNegative"),
                        deserializeJSONToList(FilePaths.TAGS, Pet.Tag.class), "Cngo" },
        };
    }
    @DataProvider(name = "petGet")
    public Object[][] petGet() {
        return new Object[][]{
                {123},
                {134},
        };
    }

    @Test(dataProvider = "petGet")
    void test(String petId) {
        Pet petResponse = getRequest("/" + petId, Pet.class);
        Pet expectedResponse = Pet.builder()
                .id(11)
                .name("Eagle")
                .category(Pet
                        .Category.builder()
                        .name("aaa")
                        .id(1)
                        .build())
                .build();
    }

    @Test(dataProvider = "petCreate")
    void cratePet(Integer id, String name, Integer categoryId, String categoryName,
                  List<String> photoUrls, List<Pet.Tag> tags, String status) {
        Pet requestBody = Pet.builder()
                .id(id)
                .name(name)
                .category(Pet
                        .Category.builder()
                        .name(categoryName)
                        .id(categoryId)
                        .build())
                .photoUrls(photoUrls)
                .status(status)
                .tags(tags)
                .build();
        Response petResponse = postRequest("", requestBody);
    }

}
