package org.example.Exercise.httpServer;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseQuery {
    public static void parseQuery(String query, Map<String, Object> parameters) throws ClassCastException {

        if (query != null) {
            String[] params = query.split("&");
            for (String param : params) {
                String[] newQuery = param.split("=");
                String key = null;
                String value = null;
                if (newQuery.length > 0) {
                    key = URLDecoder.decode(newQuery[0]);
                }
                if (newQuery.length > 1) {
                    Object object = parameters.get(key);
                    if (object instanceof List<?>) {
                        List<String> values = (List<String>) object;
                        values.add(value);


                    } else if (object instanceof String) { // put the header-data which is a string into the parameter
                        List<String> values = new ArrayList<>();
                        values.add(value);
                        parameters.put(key, values);

                    }

                } else {
                    parameters.put(key, value);
                }
            }

        }
    }
}
