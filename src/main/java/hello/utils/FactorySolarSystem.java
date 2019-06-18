package hello.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.pojo.Planet;
import hello.pojo.SolarSystem;


public class FactorySolarSystem {
	
	private static final String FERENGI = "Ferengi";
	private static final String VULCANO = "Vulcano";
	private static final String BETASOIDE = "Betasoide";
	
	private static final Double FIVE_DEGREES = 5d;
	private static final Double MINUS_ONE_DEGREE = -1d;
	private static final Double MINUS_THREE_DEGREES = -3d;
	
	private static final Double INITIAL_POSITION_ON_DEGREES = 90d;
	
	private static final Double KM_500 = 500d;
	private static final Double KM_1000 = 1000d;
	private static final Double KM_2000 = 2000d;
	private static final String MERCADO_LIBRE_SOLARSYSTEM ="MercadoLibre";
	

	public static SolarSystem getSolarSystem(String name) {
		
		if(name.equalsIgnoreCase(MERCADO_LIBRE_SOLARSYSTEM))
	         return givmeAMercadoLibreSolarSystem();
		return null;
	}
		
	private static SolarSystem givmeAMercadoLibreSolarSystem() {
		Planet ferengi = new Planet(FERENGI,KM_500,INITIAL_POSITION_ON_DEGREES,MINUS_ONE_DEGREE);
		Planet vulcano = new Planet(VULCANO ,KM_1000,INITIAL_POSITION_ON_DEGREES,FIVE_DEGREES);
		Planet betasoide = new Planet(BETASOIDE,KM_2000,INITIAL_POSITION_ON_DEGREES,MINUS_THREE_DEGREES);
		
		List<Planet> planets = new ArrayList<>();
		planets.add(ferengi);
		planets.add(vulcano);
		planets.add(betasoide);
		
		SolarSystem mercadoLibre = new SolarSystem(planets, MERCADO_LIBRE_SOLARSYSTEM);
		return mercadoLibre;
	}
		
}

