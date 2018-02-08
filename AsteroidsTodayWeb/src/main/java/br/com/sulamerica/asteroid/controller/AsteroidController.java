package br.com.sulamerica.asteroid.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sulamerica.asteroid.model.Asteroid;
import br.com.sulamerica.asteroid.service.AsteroidService;


@Controller
public class AsteroidController {

	@Autowired
	AsteroidService asteroidService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		final String todayDate = LocalDate.now(ZoneId.of("America/Sao_Paulo")).toString();
		List<Asteroid> asteroids = asteroidService.retrieveAsteroids(todayDate);
		model.addAttribute("asteroids", asteroids);
		return "home";
	}
	
}
