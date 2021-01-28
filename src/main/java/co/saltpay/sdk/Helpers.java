package co.saltpay.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;

public class Helpers {

    static String fromQueryString(String queryString) throws JsonProcessingException, JSONException {
        String[] queryArray = queryString.split("&");
        String[] id = queryArray[0].split("=");
        String[] location = queryArray[1].split("=");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(id[0], id[1]);
        jsonObject.put(location[0], location[1]);
        return jsonObject.toString();
    }
}
