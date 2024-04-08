package org.example.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Writing to a URL is also known as HTTP posting. it is a POST request.
 */
public class WriteUrl {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("usage:  java Reverse \"\n" + "                + \"http://<location of your servlet/script>\"\n" + "                + \" string_to_reverse\");");
            System.exit(1);
        }
        String stringToReverse = URLEncoder.encode(args[1], StandardCharsets.UTF_8);
        URL url = new URL(args[0]);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
        out.write(STR."String =  \{stringToReverse}");
        out.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();

    }

}
