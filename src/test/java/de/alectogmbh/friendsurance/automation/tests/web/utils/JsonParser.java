package de.alectogmbh.friendsurance.automation.tests.web.utils;


import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser {

    public <T> T mapToObject(String FILE_PATH_JSON, Class<T> targetClass) {
        JSONObject jsonObject = readFromFile(FILE_PATH_JSON);
        return new Gson().fromJson(jsonObject.toJSONString(), targetClass);
    }

    private JSONObject readFromFile(String filePath) {
        JSONObject data = null;
        try {
            data = (JSONObject) new JSONParser().parse(new FileReader(filePath));
        } catch (IOException | ParseException e) {
            System.err.println(e);
        }
        return data;
    }
}
