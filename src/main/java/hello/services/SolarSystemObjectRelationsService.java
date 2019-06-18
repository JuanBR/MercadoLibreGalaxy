package hello.services;

import hello.pojo.SolarSystem;

public interface SolarSystemObjectRelationsService {

	Double calculateTrianglePerimeter(SolarSystem solarSystem);

	Boolean isSunInsideOfTheTriangle(SolarSystem solarSystem);

	Boolean onlyPlanetsAreAlligned(SolarSystem solarSystem);

	Boolean allPlanetsAreAllignWithTheSun(SolarSystem solarSystem);

	Double getMaxTrianglePerimeter(SolarSystem solarSystem);


}
