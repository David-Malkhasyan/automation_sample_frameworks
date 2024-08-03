package enums;

public enum ExecutionEnvironment {
    TEST("test", "test.app.test"),
    STAGE("stage", "test.app.stage");

    private final String appBundleId;
    private final String envName;

    ExecutionEnvironment(String envName, String appBundleId) {
        this.envName = envName;
        this.appBundleId = appBundleId;
    }

    public static ExecutionEnvironment getElementByValue(String value) {
        for (ExecutionEnvironment element : values()) {
            if (element.envName.equals(value.toLowerCase())) {
                return element;
            }
        }
        return null;
    }

    public String getAppBundleId() {
        return appBundleId;
    }
}
