package client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.testng.annotations.BeforeTest;
import swagger.petStore.enums.FilePaths;
import swagger.petStore.exception.PetStoreException;
import swagger.petStore.helpers.DataReader;
import swagger.petStore.pojo.pet.Pet;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static swagger.petStore.helpers.DataReader.deserializeJSONToList;
import static swagger.petStore.helpers.DataReader.readUrlListFromJson;

public class BaseClient {
    protected Logger logger;
    protected RequestSpecification requestSpec;
    protected List<Pet.Tag> tags;
    protected List<String> urls;


    protected BaseClient() {
        requestSpec = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .setContentType("application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
        logger = LogManager.getLogger(this.getClass().getSimpleName());
//        LoggerContext context = (LoggerContext) LogManager.getContext(false);
//        try {
//            context.setConfigLocation(Objects.requireNonNull(this.getClass().getResource("log4j.xml")).toURI());
//        } catch (Exception e) {
//            logger.error("can't find config file");
//            throw new PetStoreException("can't find log4j.xml file");
//        }
    }

    @BeforeTest
    public void deserializeDynamicData() {
//        tags = deserializeJSONToList(FilePaths.TAGS, Pet.Tag.class);
//        urls = readUrlListFromJson(FilePaths.URLS, "urlPositive");
    }

    public <T> T getRequest(String endpoint, Class<T> responsePojo) {
        logger.info("Get request to endpoint: {}", endpoint);
        logger.info("Get request to endpoint: {}");
        Response response = RestAssured
                .given(requestSpec)
                .when()
                .get(endpoint);
        logger.info("Response. Get request to endpoint with status code: {} and time: {}", response.statusCode(), response.time());
        return response.getBody().as(responsePojo);
    }

    public Response postRequest(String endpoint, Object requestObject) {
        logger.info("Get request to endpoint: {}", endpoint);
        logger.info("Get request to endpoint: {}");
        Response response = RestAssured
                .given(requestSpec)
                .when()
                .body(requestObject)
                .post(endpoint);
        logger.info("Response. Get request to endpoint with status code: {} and time: {}", response.statusCode(), response.time());
        return response;
    }

}
