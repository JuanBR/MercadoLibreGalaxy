package hello.services;

import java.util.List;

import hello.pojo.Coordinates;

public interface TwoDimensionalCartesianCoordinatesService {

	Boolean areAllPointAllignWithPointP(List<Coordinates> points, Coordinates pointP);
	
	Boolean areAllPointAllignButNotWithPointP(List<Coordinates> points, Coordinates pointP);
	
	Boolean isThePointPInsideTheTriangleABC(List<Coordinates> triangleCoordinatesPoints, Coordinates pointP);
	
	Double calculateTrianglePerimeter(List<Coordinates> triangleCoordinatesPoints);
}
