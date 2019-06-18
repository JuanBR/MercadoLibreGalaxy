package hello.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hello.pojo.CartesianTriangle;
import hello.pojo.Coordinates;

@Service
public class TwoDimensionalCartesianCoordinatesServiceImpl implements TwoDimensionalCartesianCoordinatesService {
	
	@Override
	public Boolean areAllPointAllignWithPointP(List<Coordinates> points, Coordinates pointP) {
		return isAVerticalAlligmentWithPointP(points, pointP) || isAAlligmentWithPointP(points, pointP) ;
		
	}
	
	@Override
	public Boolean areAllPointAllignButNotWithPointP(List<Coordinates> points, Coordinates pointP) {
		return isAVerticalAlligmentButNotWithPointP(points, pointP) || isAAlligmentButNotWithPointP(points, pointP);
		
	}
	
	private boolean isAVerticalAlligmentButNotWithPointP(List<Coordinates> points, Coordinates pointP) {
		Coordinates firstPoint = points.get(0);
		return firstPoint.getPositionOnX().compareTo(pointP.getPositionOnX()) != 0 && allElementsTheSameX(points, firstPoint);
		
	}
	
	private boolean isAVerticalAlligmentWithPointP(List<Coordinates> points, Coordinates pointP) {
		return allElementsTheSameX(points, pointP);
	}
	
	private boolean allElementsTheSameX(List<Coordinates> list, Coordinates point) {
	    return list.stream().allMatch(x -> x.getPositionOnX().equals(point.getPositionOnX()));
	}
	
	private boolean isAAlligmentButNotWithPointP(List<Coordinates> pointsList, Coordinates pointP) {
		List<Coordinates> points = new ArrayList<Coordinates>(pointsList);
		Coordinates pointA = points.get(0);
		points.remove(0);
		Coordinates pointB = points.get(0);
		
		Double slopeWhitCenter = allignWithOtherPointAndObtainSlope(pointA, pointP);
		Double slopeAB = allignWithOtherPointAndObtainSlope(pointA, pointB);
		Boolean allElementsHaveTheSlopeAB = points.stream().allMatch(x ->  slopeAB.equals(allignWithOtherPointAndObtainSlope(x, pointA)));
		
		return slopeWhitCenter.compareTo(slopeAB) != 0 && allElementsHaveTheSlopeAB;
	}
	
	private boolean isAAlligmentWithPointP(List<Coordinates> pointsList, Coordinates pointP) {
		List<Coordinates> points = new ArrayList<Coordinates>(pointsList);
		Coordinates pointA = points.get(0);
		points.remove(0);
		Double slope = allignWithOtherPointAndObtainSlope(pointA, pointP);
		return points.stream().allMatch(x ->  slope.equals(allignWithOtherPointAndObtainSlope(x, pointP)));
	}
	
	private Double allignWithOtherPointAndObtainSlope(Coordinates pointA, Coordinates pointB) {
		Double slope = 0d;
		slope = (pointA.getPositionOnY() - pointB.getPositionOnY()) / (pointA.getPositionOnX() - pointB.getPositionOnX());
		return slope;
	}
	
	@Override
	public Boolean isThePointPInsideTheTriangleABC(List<Coordinates> triangleCoordinatesPoints, Coordinates pointP) {
		Coordinates pointA = triangleCoordinatesPoints.get(0);
		Coordinates pointB = triangleCoordinatesPoints.get(1);
		Coordinates pointC = triangleCoordinatesPoints.get(2);
		
		CartesianTriangle triangle = new CartesianTriangle(pointA,pointB,pointC);
		return triangle.isThePointPInsideTheTriangleABC(pointP);
	}
	
	@Override
	public Double calculateTrianglePerimeter(List<Coordinates> triangleCoordinatesPoints) {
		Coordinates pointA = triangleCoordinatesPoints.get(0);
		Coordinates pointB = triangleCoordinatesPoints.get(1);
		Coordinates pointC = triangleCoordinatesPoints.get(2);
		
		CartesianTriangle triangle = new CartesianTriangle(pointA,pointB,pointC);
		return triangle.getPerimeter();
	}
	
	
	
	
	
}
