package com.tts.mapsapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tts.mapsapp.models.GeocodingResponse;
import com.tts.mapsapp.models.Location;

//want to be able to autowire to create a MapServce

@Service //tells programmers + SpringBoot that this is meant to be a service
		// causes SB to add MapService to auto-object management to be able to autowire
		//makes the MapService into a Bean to be managed by SB version control system
public class MapService {
	@Value("${api_key}")
	private String apiKey;
	
	//talk to an API
	public void addCoordinates(Location location) {
		//take (City,State) object and return coords from google geocoding API
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location.getCity() +"," + location.getState()+ "&key=" + apiKey; 
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		location.setLat(coordinates.getLat());
		location.setLng(coordinates.getLng());
	}
}
