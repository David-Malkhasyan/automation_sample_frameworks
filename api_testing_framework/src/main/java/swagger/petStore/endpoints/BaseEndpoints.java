package swagger.petStore.endpoints;

public enum BaseEndpoints {
    PROTOCOL("https://"),
    DOMAIN("petstore.swagger.io"),
    APIV2("v2");

    private final String baseEndpointValue;

    BaseEndpoints(String actualName) {
        this.baseEndpointValue = actualName;
    }

    public String getValue() {
        return baseEndpointValue;
    }
}
