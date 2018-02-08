package br.com.sulamerica.asteroid.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sulamerica.asteroid.model.Asteroid;

@Service
public class AsteroidService {

	@Value( "${api.neo.url}" )
	private String neoFeedUrl;
	
	/**
	 * Retrieves a list of Near Earth Asteroids from NASA API
	 * @param date
	 * @return
	 */
	public List<Asteroid> retrieveAsteroids(String date) {
	
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("date", date);
		
		// Build URI
		UriComponentsBuilder builder = UriComponentsBuilder
			// Feed URL
		    .fromUriString(neoFeedUrl);

		// Exec external API call
		RestTemplate restTemplate = new RestTemplate();
		Asteroid[] asteroids = restTemplate.getForObject(builder.buildAndExpand(uriParams).toUri(), Asteroid[].class);
		return Arrays.asList(asteroids);
	}
	
}
