package hello;

import java.time.temporal.ChronoUnit;

public class SolarSystem {
	
	private static final String FERENGI = "Ferengi";
	private static final String VULCANO = "Vulcano";
	private static final String BETASOIDE = "Betasoide";
	
	private static final Double FIVE_DEGREES = 5d;
	private static final Double MINUS_ONE_DEGREE = -1d;
	private static final Double MINUS_THREE_DEGREES = -3d;
	
	private static final Double INITIAL_POSITION_ON_DEGREES = 90d;
	private static final Long INITIAL_DAY = 1l;
	
	private static final Integer KM_500 = 500;
	private static final Integer KM_1000 = 1000;
	private static final Integer KM_2000 = 2000;
	
	private RelationBetweenSolarSystemObjectAndWheather relationBetweenSolarSystemObjectAndWheather;
	
	private Long currentDay;
	private Double maxTrianglePerimeter;

	private Planet ferengi;
	private Planet vulcano;
	private Planet betasoide;
	
	
	
	
	public SolarSystem() {
		super();
		setSolarSytemToDayOne();
	}
	
	private void setSolarSytemToDayOne() {
		ferengi = new Planet(FERENGI,KM_500,INITIAL_POSITION_ON_DEGREES,MINUS_ONE_DEGREE);
		vulcano = new Planet(VULCANO ,KM_1000,INITIAL_POSITION_ON_DEGREES,FIVE_DEGREES);
		betasoide = new Planet(BETASOIDE,KM_2000,INITIAL_POSITION_ON_DEGREES,MINUS_THREE_DEGREES);
		currentDay = INITIAL_DAY;
		relationBetweenSolarSystemObjectAndWheather = RelationBetweenSolarSystemObjectAndWheather.SUN_ALLIGNE_WITH_PLANETS;
		maxTrianglePerimeter = 0d;
	}
	
	public SolarSystem(Long desiredDay) {
		this();
		setSolarSystemToAnSpecificDay(desiredDay);
	}
	
	public Long getCurrentDay() {
		return currentDay;
	}

	public String getWeatherDescription() {
		return relationBetweenSolarSystemObjectAndWheather.getWeatherDescription();
	}
	
	
	public void setSolarSystemToAnSpecificDay(Long desiredDay) {
		movePlanets(desiredDay);
		calculateRelationsBetweenPlanets();
	}
	

	private void movePlanets(Long desiredDay) {
		for (Long i = currentDay; i < desiredDay; i++) {
			ferengi.moveOnDay();
			vulcano.moveOnDay();
			betasoide.moveOnDay();
			currentDay++;
		}
	}

	private void calculateRelationsBetweenPlanets() {
		relationBetweenSolarSystemObjectAndWheather = RelationBetweenSolarSystemObjectAndWheather.UNKNOWN;
		checkIfAllPlanetsAreAllignWithTheSun();
		checkIfOnlyPlanetsAreAlligned();
		checkIfTheSunIsInTheTheTriangle();
		
	}


	private void checkIfTheSunIsInTheTheTriangle() {
		if(isRelationUnknow() && isSunInsideOfTheTriangle()) {
			relationBetweenSolarSystemObjectAndWheather = RelationBetweenSolarSystemObjectAndWheather.TRIANGLE_WITH_SUN_INSIDE;
			checkIfTheSunIsInTheTheTriangleWithMaxPerimeter();
		}
		
	}
	
	private void checkIfTheSunIsInTheTheTriangleWithMaxPerimeter() {
		Double currentPerimeter = getTrianglePerimeter();
		if(currentPerimeter >= maxTrianglePerimeter) {
			maxTrianglePerimeter = currentPerimeter;
			relationBetweenSolarSystemObjectAndWheather = RelationBetweenSolarSystemObjectAndWheather.TRIANGLE_WITH_SUN_INSIDE_MAX_PERIMETER;
		}
	}

	private Double getTrianglePerimeter() {
		return getDistanceFerengiVulcano() + getDistanceVulcanoBetasoide() + getDistanceFerengiBetasoide();
	}
	
	private Double getDistanceFerengiVulcano() {
		return ferengi.getDistanceBetweenPlanets(vulcano);
	}
	
	private Double getDistanceVulcanoBetasoide() {
		return vulcano.getDistanceBetweenPlanets(betasoide);
	}
	
	private Double getDistanceFerengiBetasoide() {
		return ferengi.getDistanceBetweenPlanets(betasoide);
	}
	
	private Boolean isSunInsideOfTheTriangle() {
		return allThreeMathematicalOrientationWithSunPositive() || allThreeMathematicalOrientationWithSunNegative();
	}
	
	private Boolean allThreeMathematicalOrientationWithSunPositive() {
		return triangleMathematicalOrientationFerengiVulcanoSun() > 0d 
				&& triangleMathematicalOrientationVulcanoBetasoideSun() > 0d
				&& triangleMathematicalOrientationBetasoideFerengiSun() > 0d;
	}
	
	private Boolean allThreeMathematicalOrientationWithSunNegative() {
		return triangleMathematicalOrientationFerengiVulcanoSun() < 0d 
				&& triangleMathematicalOrientationVulcanoBetasoideSun() < 0d
				&& triangleMathematicalOrientationBetasoideFerengiSun() < 0d;
	}
	
	
	
	private Double triangleMathematicalOrientationFerengiVulcanoSun() {
		return ferengi.triangleMathematicalOrientationWithOtherPlanetAndSun(vulcano);
	}
	
	private Double triangleMathematicalOrientationVulcanoBetasoideSun() {
		return vulcano.triangleMathematicalOrientationWithOtherPlanetAndSun(betasoide);
	}
	
	private Double triangleMathematicalOrientationBetasoideFerengiSun() {
		return betasoide.triangleMathematicalOrientationWithOtherPlanetAndSun(ferengi);
	}

	private Boolean isRelationUnknow() {
		return relationBetweenSolarSystemObjectAndWheather.equals(RelationBetweenSolarSystemObjectAndWheather.UNKNOWN);
	}

	private void checkIfOnlyPlanetsAreAlligned() {
		if(isRelationUnknow() && (isAVerticalAlligmentOnlyPlanets() || onlyAllThreePlanetsAlligment()) )
			relationBetweenSolarSystemObjectAndWheather = RelationBetweenSolarSystemObjectAndWheather.ONLY_PLANETS_ALLIGNED;
	}

	private void checkIfAllPlanetsAreAllignWithTheSun() {
		if(isRelationUnknow() && (isAVerticalAlligmentWithTheSun() || allThreePlanetsAlligmentWithTheSun()) )
			relationBetweenSolarSystemObjectAndWheather = RelationBetweenSolarSystemObjectAndWheather.SUN_ALLIGNE_WITH_PLANETS;
	}

	private boolean allThreePlanetsAlligmentWithTheSun() {
		return allThreePlanetsAlligment()
				&& ferengi.allignWithTheSunAndObtainSlope().compareTo(ferengi.allignWithOtherPlanetAndObtainSlope(betasoide)) == 0;
	}
	
	private boolean onlyAllThreePlanetsAlligment() {
		return allThreePlanetsAlligment()
				&& ferengi.allignWithTheSunAndObtainSlope().compareTo(ferengi.allignWithOtherPlanetAndObtainSlope(betasoide)) != 0;
	}
	
	private boolean allThreePlanetsAlligment() {
		return ferengi.allignWithOtherPlanetAndObtainSlope(vulcano)
				.compareTo(ferengi.allignWithOtherPlanetAndObtainSlope(betasoide)) == 0;
	}

	private boolean isAVerticalAlligment() {
		return ferengi.getPositionOnX().compareTo(vulcano.getPositionOnX()) == 0 
		&& ferengi.getPositionOnX().compareTo(betasoide.getPositionOnX()) == 0;
	}
	
	private boolean isAVerticalAlligmentWithTheSun() {
		return isAVerticalAlligment()
		&& ferengi.isAVerticalAlligmentWithTheSun();
	}
	
	private boolean isAVerticalAlligmentOnlyPlanets() {
		return isAVerticalAlligment()
		&& !ferengi.isAVerticalAlligmentWithTheSun();
	}
}
