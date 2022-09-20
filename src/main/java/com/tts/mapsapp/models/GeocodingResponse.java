package com.tts.mapsapp.models;

import java.util.List;

import lombok.Data;

//this class holds the json result that we get from a geocoding query

//set my RestTemplate.getForObj() that reads the JSON form remote site and maps it to this class

@Data
public class GeocodingResponse {
	private List<Geocoding> results;
	String status;
}
