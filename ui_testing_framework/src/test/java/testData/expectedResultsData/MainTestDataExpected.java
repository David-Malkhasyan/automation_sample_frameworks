package testData.expectedResultsData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainTestDataExpected {
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

    public void setInvalidLogin(String invalidLogin) {
        this.invalidLogin = invalidLogin;
    }


    public String getLongUsername() {
        return longUsername;
    }

    public void setLongUsername(String longUsername) {
        this.longUsername = longUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}