package com.tts.mapsapp.models;

import lombok.Data;

//in this project, location is used multipuerposely. Location stores lat and long that can be 
// recived in a getForObject call, but the project also uses Location to store city, state from the form

@Data
public class Location {
	//these are not used in RestTemplate-- not in JSON
	private String city;
	private String state;
	//these are use din RestTemplate.getForObject;
	private String lat;
	private String lng;
}
