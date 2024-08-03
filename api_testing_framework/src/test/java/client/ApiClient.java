package client;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ApiClient<T> extends BaseClient {


    public <K, V> Response post(String endpoint, T requestBody, Map<String, K> header, Map<String, V> queryParam) {
        logger.info("Post request to endpoint: {}", endpoint);
        Response response = RestAssured.given(requestSpec)
                .when()
                .headers(header)
                .queryParams(queryParam)
                .body(requestBody)
                .request(Method.POST, endpoint);
        logger.info("Response. Post request to endpoint with status code: {} and time: {}", response.statusCode(), response.time());
        return response;
    }

    public <K, V> Response post(String endpoint, Map<String, K> header, Map<String, V> queryParam) {
        logger.info("Post request to endpoint: {}", endpoint);
        Response response = RestAssured.given(requestSpec)
                .when()
                .headers(header)
                .queryParams(queryParam)
                .request(Method.POST, endpoint);
        logger.info("Response. Post request to endpoint with status code: {} and time: {}", response.statusCode(), response.time());
        return response;
    }

    public <K, V> Response postWithFormParams(String endpoint, Map<String, K> header, Map<String, V> formParam) {
        logger.info("Post request to endpoint: {}", endpoint);
        Response response = RestAssured.given(requestSpec)
                .when()
                .headers(header)
                .formParams(formParam)
                .request(Method.POST, endpoint);
        logger.info("Response. Post request to endpoint with status code: {} and time: {}", response.statusCode(), response.time());
        return response;
    }

    public <V> Response post(String endpoint, Map<String, V> queryParam) {
        return post(endpoint, Collections.emptyMap(), queryParam);
    }

    public Response post(String endpoint) {
        return post(endpoint, Collections.emptyMap(), Collections.emptyMap());
    }

    public Response post(String endpoint, T requestBody) {
        return post(endpoint, requestBody, Collections.emptyMap(), Collections.emptyMap());
    }

    public <K> Response postWithHeader(String endpoint, T requestBody, Map<String, K> header) {
        return post(endpoint, requestBody, header, Collections.emptyMap());
    }

    public <V> Response postWithQueryParam(String endpoint, T requestBody, Map<String, V> queryParam) {
        return post(endpoint, requestBody, Collections.emptyMap(), queryParam);
    }

    public <K, V> Response postWithArrayBody(String endpoint, List<T> requestBody, Map<String, K> header, Map<String, V> queryParam) {
        logger.info("Post request to endpoint: {}", endpoint);
        Response response = RestAssured.given(requestSpec)
                .when()
                .headers(header)
                .queryParams(queryParam)
                .body(requestBody)
                .request(Method.POST, endpoint);
        logger.info("Response. Post request to endpoint with status code: {} and time: {}", response.statusCode(), response.time());
        return response;
    }

    public Response postWithArrayBody(String endpoint, List<T> requestBody) {
        return postWithArrayBody(endpoint, requestBody, Collections.emptyMap(), Collections.emptyMap());
    }

    public <K, V> Response get(String endpoint, Map<String, K> header, Map<String, V> queryParam) {
        logger.info("Get request to endpoint: {}", endpoint);
        Response response = RestAssured.given(requestSpec)
                .when()
                .headers(header)
                .queryParams(queryParam)
                .request(Method.GET, endpoint);
        logger.info("Response. Get request to endpoint with status code: {} and time: {}", response.statusCode(), response.time());
        return response;
    }

    public Response get(String endpoint) {
        return get(endpoint, Collections.emptyMap(), Collections.emptyMap());
    }

    public <K> Response getWithHeader(String endpoint, Map<String, K> header) {
        return get(endpoint, header, Collections.emptyMap());
    }

    public <V> Response getWithQueryParam(String endpoint, Map<String, V> queryParam) {
        return get(endpoint, Collections.emptyMap(), queryParam);
    }

    public <K, V> Response put(String endpoint, List<T> requestBody, Map<String, K> header, Map<String, V> queryParam) {
        logger.info("Put request to endpoint: {}", endpoint);
        Response response = RestAssured.given(requestSpec)
                .when()
                .headers(header)
                .queryParams(queryParam)
                .body(requestBody)
                .request(Method.PUT, endpoint);
        logger.info("Response. Put request to endpoint with status code: {} and time: {}", response.statusCode(), response.time());
        return response;
    }

    public Response put(String endpoint, List<T> requestBody) {
        return put(endpoint, requestBody, Collections.emptyMap(), Collections.emptyMap());
    }

    public <V> Response delete(String endpoint, Map<String, V> queryParam) {
        logger.info("Delete request to endpoint: {}", endpoint);
        Response response = RestAssured.given(requestSpec)
                .when()
                .queryParams(queryParam)
                .request(Method.DELETE, endpoint);
        logger.info("Response. Delete request to endpoint with status code: {} and time: {}", response.statusCode(), response.time());
        return response;
    }

    public Response delete(String endpoint) {
        return delete(endpoint, Collections.emptyMap());
    }

}
