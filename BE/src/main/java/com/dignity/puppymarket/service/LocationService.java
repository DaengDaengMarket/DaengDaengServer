package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.User;
import com.dignity.puppymarket.dto.LocationCreateRequestDto;
import com.dignity.puppymarket.dto.LocationRequestDto;
import com.dignity.puppymarket.dto.LocationResponseDto;
import com.dignity.puppymarket.error.LocationNotFoundException;
import com.dignity.puppymarket.error.UserNotFoundException;
import com.dignity.puppymarket.repository.UserRepository;
import com.dignity.puppymarket.security.UserAuthentication;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class LocationService {
    @Value("${geolocation.apikey}")
    private String apiKey;

    private final UserRepository userRepository;

    public LocationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LocationResponseDto findLocation(LocationRequestDto locationRequestDto) {
        URL apiAddress = getApiAddress(locationRequestDto);
        String jsonData = getJSONData(apiAddress);
        String regionAddress = getRegionAddress(jsonData);
        String[] address = regionAddress.split(" ");
        String si = address[1];
        String gu = address[2];

        return LocationResponseDto.of(si, gu);
    }

    public URL getApiAddress(LocationRequestDto locationRequestDto) {
        Double latitude = locationRequestDto.getLatitude();
        Double longitude = locationRequestDto.getLongitude();
        String apiURL = "https://maps.googleapis.com/maps/api/geocode/json?latlng="
                + latitude + "," + longitude + "&key=" + apiKey + "&language=ko";

        URL url = null;
        try {
            url = new URL(apiURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return url;
    }

    public String getJSONData(URL url) {
        StringBuilder sb = new StringBuilder();
        String buf = "";

        try(BufferedReader br = new BufferedReader(new InputStreamReader(
                url.openStream(), StandardCharsets.UTF_8))) {
            while ((buf = br.readLine()) != null) {
                sb.append(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String getRegionAddress(String jsonString) {
        JSONObject jObj = (JSONObject) JSONValue.parse(jsonString);
        if(jObj == null) {
            throw new LocationNotFoundException("현재 위치를 찾을 수 없습니다");
        }

        JSONArray jArray = (JSONArray) jObj.get("results");
        jObj = (JSONObject) jArray.get(0);
        return (String) jObj.get("formatted_address");
    }

    public LocationResponseDto saveLocation(Long id,
                                            LocationCreateRequestDto locationCreateRequestDto,
                                            UserAuthentication userAuthentication) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        if(!user.isSame(userAuthentication.getEmail())) {
            throw new AccessDeniedException("접근 권한이 없습니다");
        }

        String guCode = locationCreateRequestDto.getGu();
        String siCode = locationCreateRequestDto.getSi();
        user.updateLocationWith(guCode, siCode);

        return LocationResponseDto.of(guCode, siCode);
    }
}
