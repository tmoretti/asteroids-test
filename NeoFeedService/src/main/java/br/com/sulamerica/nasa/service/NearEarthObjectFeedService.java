package br.com.sulamerica.nasa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sulamerica.nasa.model.Asteroid;
import br.com.sulamerica.nasa.model.neo.NearEarthObject;
import br.com.sulamerica.nasa.model.neo.NearEarthObjectFeed;

@Service
public class NearEarthObjectFeedService {

	@Value( "${api.nasa.feed_url}" )
	private String neoFeedUrl;
	
	@Value( "${api.nasa.api_key}" )
	private String apiKey;
		
	/**
	 * Retrieves a list of Near Earth Asteroids from NASA API
	 * @param date
	 * @return
	 */
	public List<Asteroid> retrieveAsteroids(String date) {
	
		NearEarthObjectFeed neoFeed = getNeoFeed(date, date);
		List<NearEarthObject> nearEarthObjects = neoFeed.getNearEarthObjects().get(date);
		return convertToAsteroids(nearEarthObjects);
	}
	
	/**
	 * Retrieves a list of Earth Hazardous Asteroids from NASA API
	 * 
	 * @param date - the date to search
	 * @return
	 */
	public List<Asteroid> retrieveEarthHazardousAsteroids(String date) {
		
		// get full feed
		NearEarthObjectFeed neoFeed = getNeoFeed(date, date);
		
		List<NearEarthObject> nearEarthObjects = neoFeed.getNearEarthObjects().get(date);
		
		// Filter Hazardous NEOs 
		List<NearEarthObject> hazardousNEOs = nearEarthObjects.stream().filter(neo -> {
			
			// Check CloseApproachData for Earth Orbiting Elements
			boolean isOrbitingEarth = neo.getCloseApproachData().stream()
	                .anyMatch(closeApproach -> "Earth".equals(closeApproach.getOrbitingBody()));
			
			// return true if is both matchs 
		    return neo.isPotentiallyHazardousAsteroid() && isOrbitingEarth;
		}).collect(Collectors.toList());
				
		// convert to Asteroids POJO and return
		return convertToAsteroids(hazardousNEOs);

	}
	
	/**
	 * Get NearEarthObjectFeed from NASA API
	 * 
	 * @param startDate - the start date to search for 
	 * @param endDate - the end date to search for 
	 * @return
	 */
	private NearEarthObjectFeed getNeoFeed(String startDate, String endDate) {
		
		// Build URI
		UriComponentsBuilder builder = UriComponentsBuilder
			// Feed URL
		    .fromUriString(neoFeedUrl)
		    // Add query parameters
		    .queryParam("start_date", startDate)
		    .queryParam("end_date", endDate)
		    .queryParam("api_key", apiKey);

		// Exec external API call
		RestTemplate restTemplate = new RestTemplate();
		NearEarthObjectFeed neoFeed = restTemplate.getForObject(builder.toUriString(), NearEarthObjectFeed.class);
		return neoFeed;
	}
	
	/**
	 * Convert a list of {@link NearEarthObject} to a list of ${@link Asteroid} using Java 8 streams
	 * 
	 * @param neos
	 * @return
	 */
	private List<Asteroid> convertToAsteroids(List<NearEarthObject> neos) {
		return neos.stream().map(neo -> {
			return new Asteroid(neo.getNeoReferenceid(), neo.getName(), neo.getCloseApproachData().get(0).getRelativeVelocity().getKilometersPerHour());
		}).collect(Collectors.toList());
	}
}
