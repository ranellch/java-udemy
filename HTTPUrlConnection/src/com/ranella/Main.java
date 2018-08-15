package com.ranella;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); //default request method
            connection.setRequestProperty("User-Agent","Chrome");
            connection.setReadTimeout(10000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if(responseCode != 200) {
                System.out.println("Error reading web page");
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

            inputReader.close();

        } catch(MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
