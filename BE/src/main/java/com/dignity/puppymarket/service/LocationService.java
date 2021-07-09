package com.dignity.puppymarket.service;

import com.dignity.puppymarket.dto.LocationRequestDto;
import com.dignity.puppymarket.dto.LocationResponseDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

@Service
public class LocationService {
    @Value("${geolocation.apikey")
    private String apiKey;

    public LocationResponseDto findLocation(LocationRequestDto locationRequestDto) throws Exception {
        String apiAddress = getApiAddress(locationRequestDto);
        String jsonData = getJSONData(apiAddress);
        String[] address = jsonData.split(" ");
        String si = address[1];
        String gu = address[2];

        return LocationResponseDto.of(null, null);
    }

    public String getApiAddress(LocationRequestDto locationRequestDto) {
        String latitude = locationRequestDto.getLatitude().toString();
        String longitude = locationRequestDto.getLongitude().toString();
        String apiURL = "http://maps.googleapis.com/maps/api/geocode/json?latlng="
                + latitude + "," + longitude + "&key=" + apiKey;

        return apiURL;
    }

    public String getJSONData(String apiURL) throws Exception {
        URL url = new URL(apiURL);
        String jsonString = new String();
        String buf;
        URLConnection conn = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), StandardCharsets.UTF_8));
        while ((buf = br.readLine()) != null) {
            jsonString += buf;
        }

        return jsonString;
    }

    public String getRegionAddress(String jsonString) {
        JSONObject jObj = (JSONObject) JSONValue.parse(jsonString);
        JSONArray jArray = (JSONArray) jObj.get("results");
        jObj = (JSONObject) jArray.get(0);
        return (String) jObj.get("formatted_address");
    }
}
