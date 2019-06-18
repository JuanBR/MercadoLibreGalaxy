package hello.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.pojo.Coordinates;
import hello.pojo.SolarSystem;
import hello.utils.FactorySolarSystem;

@Service
public class SolarSystemObjectRelationsServiceImpl implements SolarSystemObjectRelationsService{

	@Autowired
	private TwoDimensionalCartesianCoordinatesService twoDimensionalCartesianCoordinatesService;
	
	
	private ArrayList<Coordinates> getPlanetsCoordinates(SolarSystem solarSystem) {
		return solarSystem.getPlanets().stream()
				.map(planet -> planet.getCoordinates())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public Double calculateTrianglePerimeter(SolarSystem solarSystem) {
		return twoDimensionalCartesianCoordinatesService.calculateTrianglePerimeter(getPlanetsCoordinates(solarSystem));
	}
	
	@Override
	public Boolean isSunInsideOfTheTriangle(SolarSystem solarSystem) {
		return twoDimensionalCartesianCoordinatesService.isThePointPInsideTheTriangleABC(getPlanetsCoordinates(solarSystem), solarSystem.getSunCoordinates());
	}

	@Override
	public Boolean onlyPlanetsAreAlligned(SolarSystem solarSystem) {
		return twoDimensionalCartesianCoordinatesService.areAllPointAllignButNotWithPointP(getPlanetsCoordinates(solarSystem), solarSystem.getSunCoordinates());
	}

	@Override
	public Boolean allPlanetsAreAllignWithTheSun(SolarSystem solarSystem) {
		return twoDimensionalCartesianCoordinatesService.areAllPointAllignWithPointP(getPlanetsCoordinates(solarSystem), solarSystem.getSunCoordinates());
	}

	@Override
	public Double getMaxTrianglePerimeter(SolarSystem solarSystem) {
		Double perimeter = 0d;
		SolarSystem solarSystemOrigin = FactorySolarSystem.getSolarSystem(solarSystem.getName()); 
		do{
			if(isSunInsideOfTheTriangle(solarSystemOrigin)) {
				Double currentPerimeter = twoDimensionalCartesianCoordinatesService.calculateTrianglePerimeter(getPlanetsCoordinates(solarSystemOrigin));
				if(currentPerimeter >= perimeter)
					perimeter = currentPerimeter;
			}
			solarSystemOrigin.moveOneDay();
		} while( !solarSystemOrigin.returnedToOriginalPosition() && solarSystemOrigin.getCurrentDay() > 1l);
		return perimeter;
	}

	
}
