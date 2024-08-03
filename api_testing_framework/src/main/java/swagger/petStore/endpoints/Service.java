package swagger.petStore.endpoints;

public enum Service {
    PET("pet"),
    STORE("store"),
    USER("user");

    private final String serviceName;

    Service(String actualName) {
        this.serviceName = actualName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
