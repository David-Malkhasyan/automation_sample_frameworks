package swagger.petStore.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DataReader {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Reader fileReader;

    public static  <T> List<T> deserializeJSONToList(String path, Class<T> tClass) {
        List<T> deserializedList = new ArrayList<>();
        try {
            fileReader = Files.newBufferedReader(Paths.get(path));
            Type listType = TypeToken.getParameterized(List.class, tClass).getType();
            deserializedList = gson.fromJson(fileReader, listType);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }
        return deserializedList;
    }

    public  static <T> T deserializeJSONToObject(String path, Class<T> tClass) {
        T deserializedObject = null;
        try {
            fileReader = Files.newBufferedReader(Paths.get(path));
            deserializedObject = gson.fromJson(fileReader, tClass);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }
        return deserializedObject;
    }
    public static List<String> readUrlListFromJson(String filePath, String key) {
        List<String> urlList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            // Get the "url" array node
            JsonNode urlNode = rootNode.path(key);
            // Iterate over the array and add elements to the list
            if (urlNode.isArray()) {
                for (JsonNode node : urlNode) {
                    urlList.add(node.asText());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlList;
    }
}