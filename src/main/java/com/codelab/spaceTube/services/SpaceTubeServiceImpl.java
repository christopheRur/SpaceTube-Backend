package com.codelab.spaceTube.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
@Slf4j
public class SpaceTubeServiceImpl implements SpaceTubeService{

    /**
     * @return
     * @throws IOException
     */
    @Override
    public JsonObject retrieveNasaData() throws IOException {


        try{

        String apiKey ="sgSOHNvCVIXw8HrKCoyhiFEmEGUqanf6GoVODLqm";
        String apiUrl="https://api.nasa.gov/planetary/apod?api_key=" + apiKey;

        URL nasaUrl = new URL(apiUrl);

        HttpURLConnection conn = (HttpURLConnection) nasaUrl.openConnection();

            // Get response code
            int responseCode = conn.getResponseCode();
            log.info("Response Code: {}",  responseCode);

        BufferedReader reader =new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();

        String data;
        while ((data = reader.readLine()) != null) {
            response.append(data);
            log.info("Nasa Info =======> {}",data);
        }

        reader.close();
        // Parse the JSON response
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(response.toString());

        if (jsonElement.isJsonObject()) {
            return jsonElement.getAsJsonObject();
        } else {
            // Handle the case where the response is not a JSON object
            log.error("Invalid JSON response: {}", response.toString());
            return null;
        }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("==>{}",e.getLocalizedMessage());
            return null;
        }
    }
}
