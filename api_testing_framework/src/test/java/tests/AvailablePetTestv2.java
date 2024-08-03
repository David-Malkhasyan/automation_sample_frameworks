package tests;

import client.BaseClient;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import swagger.petStore.pojo.pet.Pet;

import java.util.List;

public class AvailablePetTestv2 extends BaseClient {

    @DataProvider(name = "petData")
    public Object[][] details() {
        return new Object[][]{
                {11, "Rox", 12, "Dogs",
                        urls,
                        tags,
                        "Bldo"
                },
        };
    }

    @Test
    void test() {
        Pet petResponse = getRequest("/12271222", Pet.class);
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

    @Test(dataProvider = "petData")
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
