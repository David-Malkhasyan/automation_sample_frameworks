package swagger.petStore.pojo.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;


@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet{
    Integer id;
    Category category;
    String name;
    List<String> photoUrls;
    List<Tag> tags;
    String status;

    @Builder(toBuilder = true)
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Category {
        long id;
        String name;
    }

    @Builder(toBuilder = true)
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)

    public static class Tag {
        long id;
        String name;
    }
}
