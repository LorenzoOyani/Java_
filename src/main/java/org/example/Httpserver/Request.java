package org.example.Httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Request {
    private final Map<String, String> queryParameters = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();
    private BufferedReader reader = null;
    private String path;
    private String method;
    private String fullUrl;

    Request(BufferedReader reader) {
        this.reader = reader;
    }

    public String getQueryParameters(String param) {
        return queryParameters.get(param);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public void parseQueryParameters(String queryString) {
        String[] queryStrings = queryString.split("&");
        for (String query : queryStrings) {
            int separator = query.indexOf("=");
            if (separator > -1) {
                queryParameters.put(query.substring(0, separator), query.substring(separator) + 1);
            } else {
                queryParameters.put(query, null);
            }
        }

    }
    public boolean parse() throws IOException {
        String readLine = reader.readLine();
        log(readLine);
        StringTokenizer tokenizer = new StringTokenizer(readLine);
        String[] component = new String[3];
        for (int i = 0; i < component.length; i++) {
            if (tokenizer.hasMoreTokens()) {
                component[i] = tokenizer.nextToken();
            } else {
                return false;
            }
        }

        method = component[0];
        fullUrl = component[1];
        /*Consume headers*/
        while (true) {
            String headerLines = reader.readLine();
            log(headerLines);
            if (headerLines.isEmpty()) {
                break;
            }
            int separator = headerLines.indexOf(":");
            if (separator == -1) {
                return false;
            } else {
                headers.put(headerLines.substring(0, separator), headerLines.substring(separator) + 1);
            }
        }

        if (!component[1].contains("?")) {
            path = component[1];
        } else {
            String substring = component[1].substring(0, component[1].indexOf("?"));
            path = substring;
            parseQueryParameters(substring + 1);
        }

        if (Objects.equals("/", path)) {
            path = "/index.html";
        }
        return true;

    }
    public void log(String lines) {
        System.out.println(lines);
    }

    @Override
    public String toString() {
        return STR."Request{headers=\{headers}, path='\{path}', method='\{method}'}";

    }
}
