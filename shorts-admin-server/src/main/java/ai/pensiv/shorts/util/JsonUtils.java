package ai.pensiv.shorts.util;

import ai.pensiv.shorts.exception.ShortsException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    public static String convertObjectToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ShortsException("fail convert object to json. " + object.toString());
        }
    }

    public static Object convertJsonToObject(String json, Class c) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, c);
        } catch (JsonProcessingException e) {
            throw new ShortsException("fail convert json to object. " + json);
        }
    }
}
