package hello.pojo;

public class CartesianTriangle {

	private Coordinates pointA; 
	private Coordinates pointB; 
	private Coordinates pointC;
	
	public CartesianTriangle(Coordinates pointA, Coordinates pointB, Coordinates pointC) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}
	
	public Boolean isThePointPInsideTheTriangleABC(Coordinates pointP) {
		return allThreeMathematicalOrientationWithTheCenterPositive(pointP) || allThreeMathematicalOrientationWithTheCenterNegative(pointP);
	}
	
	private Double triangleMathematicalOrientation(Coordinates pointA, Coordinates pointB, Coordinates pointC) {
		return ((pointA.getPositionOnX() - pointC.getPositionOnX()) * (pointB.getPositionOnY() - pointC.getPositionOnY()) ) 
				- ((pointA.getPositionOnY()- pointC.getPositionOnY())*(pointB.getPositionOnX() - pointC.getPositionOnX()));
	}
	
	
	private Boolean allThreeMathematicalOrientationWithTheCenterPositive(Coordinates pointP) {
		return triangleMathematicalOrientation(pointA, pointB, pointP) > 0d 
				&& triangleMathematicalOrientation(pointB, pointC, pointP) > 0d
				&& triangleMathematicalOrientation(pointC, pointA, pointP) > 0d;
	}
	
	private Boolean allThreeMathematicalOrientationWithTheCenterNegative(Coordinates pointP) {
		return triangleMathematicalOrientation(pointA, pointB, pointP) < 0d 
				&& triangleMathematicalOrientation(pointB, pointC, pointP) < 0d
				&& triangleMathematicalOrientation(pointC, pointA, pointP) < 0d;
	}
	

	public Double getPerimeter() {
		return getDistance(pointA, pointB) + getDistance(pointB, pointC) + getDistance(pointA, pointC);
	}
	
	private Double getDistance(Coordinates pointA, Coordinates pointB) {
		return Math.sqrt( 
				Math.pow((pointB.getPositionOnX() - pointA.getPositionOnX()), 2) 
				+ Math.pow((pointB.getPositionOnY() - pointA.getPositionOnY()), 2) );
	}
	

	
	
}
