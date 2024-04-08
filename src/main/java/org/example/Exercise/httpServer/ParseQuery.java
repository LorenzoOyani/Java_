package org.example.Exercise.httpServer;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseQuery {
    public static void parseQuery(String query, Map<String, Object> parameters) throws ClassCastException {

        if (query != null) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] param = pair.split("=");
                String key = null;
                String value = null;
                if (param.length > 0) {
                    key = URLDecoder.decode(param[0]);
                }
                if (param.length > 1) {
                    Object object = parameters.get(key);
                    if (object instanceof List<?>) {
                        List<String> values = (List<String>) object;
                        values.add(value);
                    } else if (object instanceof String) {
                        List<String> values = new ArrayList<>(); // create a concrete list to collect the object instances
                        values.add((String) object);
                        values.add(value);
                        parameters.put(key, values);

                    } else {
                        parameters.put(key, value);
                    }
                }
            }
        }

    }
}
