package org.example.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Reading from a URL connection is more efficient than reading directly from a URL, it also helps
 * to use the URConnection object to write to the URL``
 * */

/**
 * This program demonstrates the effectiveness of reading from a URLConnection.
 * */
public class UrlStream {
    public void main() throws Exception {
        URL url = new URL("http://facebook.com/");
        BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        input.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()) );

        try {
            URLConnection urlConnection = url.openConnection();
//            urlConnection.connect();
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}
