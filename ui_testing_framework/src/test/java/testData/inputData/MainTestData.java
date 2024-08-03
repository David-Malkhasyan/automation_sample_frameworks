package testData.inputData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainTestData {

    public static final String mainTestDataJsonPath = "src/test/resources/testData/DataForTest.json";
    @JsonProperty("invalidLogin")
    public String invalidLogin;
    @JsonProperty("longUsername")
    public String longUsername;
    @JsonProperty("password")
    public String password;
    @JsonProperty("url")
    public String url;
    @JsonProperty("username")
    public String username;

    public String getInvalidLogin() {
        return invalidLogin;
    }

    public MainTestData setInvalidLogin(String invalidLogin) {
        this.invalidLogin = invalidLogin;
        return this;
    }

    public String getLongUsername() {
        return longUsername;
    }

    public MainTestData setLongUsername(String longUsername) {
        this.longUsername = longUsername;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MainTestData setPassword(String password) {
        this.password = password;
        return this;

    }

    public String getUrl() {
        return url;
    }

    public MainTestData setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public MainTestData setUsername(String username) {
        this.username = username;
        return this;
    }
}