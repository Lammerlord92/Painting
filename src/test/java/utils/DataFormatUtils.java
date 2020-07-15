package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataFormatUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String objectToJSON(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }
}
