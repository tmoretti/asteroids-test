package br.com.sulamerica.nasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulamerica.nasa.model.Asteroid;
import br.com.sulamerica.nasa.model.AsteroidsNotFoundException;
import br.com.sulamerica.nasa.service.NearEarthObjectFeedService;
import io.swagger.annotations.ApiOperation;

@RestController
public class NearEarthObjectFeedController {

	@Autowired
	NearEarthObjectFeedService nearEarthObjectFeedService;
	
	@ApiOperation(
	         value = "Busca todos os Asteroids próoximos a Terra para a data fornecida.",
	         notes = "Uma lista de Asteroids encontrados é retornada. Paginação não é suportado atualmente.",
	         response = Asteroid.class,
	         responseContainer = "List",
	         produces = "application/json")
	@GetMapping("/asteroids/{date}")
	public List<Asteroid> retrieveAsteroids(@PathVariable String date) {
		List<Asteroid> asteroids = nearEarthObjectFeedService.retrieveAsteroids(date);
		
		if (asteroids == null  || asteroids.size() == 0) {
			throw new AsteroidsNotFoundException("Nenhum asteroide encontrado");
		}
		
		return asteroids;
	}

	@ApiOperation(
	         value = "Busca todos os Asteroids possivelmente danosos a Terra para a data fornecida.",
	         notes = "Uma lista de Asteroids encontrados é retornada. Paginação não é suportado atualmente.",
	         response = Asteroid.class,
	         responseContainer = "List",
	         produces = "application/json")
	@GetMapping("/asteroids/{date}/hazardous")
	public List<Asteroid> retrieveEarthHazardousAsteroids(@PathVariable String date) {
		List<Asteroid> asteroids = nearEarthObjectFeedService.retrieveEarthHazardousAsteroids(date);
		
		if (asteroids == null  || asteroids.size() == 0) {
			throw new AsteroidsNotFoundException("Nenhum asteroide encontrado");
		}

		return asteroids;
	}
}
