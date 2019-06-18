package hello;

public class Planet {
	
	private String name;
	private Integer distanceToTheSun;
	private Double positionOnDegree;
	private Double velocityOnDegree;
	
	private static final Double POSITION_Y_SUN = 0d;
	private static final Double POSITION_X_SUN = 0d;
	
	
	public Planet(String name, Integer distanceToTheSun, Double positionOnDegree, Double velocityOnDegree) {
		super();
		this.name = name;
		this.distanceToTheSun = distanceToTheSun;
		this.positionOnDegree = positionOnDegree;
		this.velocityOnDegree = velocityOnDegree;
	}
	
	public String getName() {
		return name;
	}

	public void moveOnDay() {
		Double resultOfAdding = positionOnDegree + velocityOnDegree;

		if(resultOfAdding < 0){
			positionOnDegree = 360d - Math.abs(resultOfAdding); 
		}else if (resultOfAdding > 360d) {
			positionOnDegree = (positionOnDegree + velocityOnDegree) % 360; 
		}
    	else if(Double.compare(resultOfAdding, 360d) == 0){
        	positionOnDegree = 0d;
        }else {
        	positionOnDegree = resultOfAdding;
        }
	}

	public Double getPositionOnX() {
		return distanceToTheSun * Math.cos(positionOnDegree);
	}


	public Double getPositionOnY() {
		return distanceToTheSun * Math.sin(positionOnDegree);
	}

	public boolean isAVerticalAlligmentWithTheSun() {
		return this.getPositionOnX().compareTo(POSITION_X_SUN) == 0;
	}
	
	public Double allignWithOtherPlanetAndObtainSlope(Planet planetToAlling) {
		Double slope = 0d;
		slope = (this.getPositionOnY() - planetToAlling.getPositionOnY()) / (this.getPositionOnX() - planetToAlling.getPositionOnX());
		return slope;
	}

	public Double allignWithTheSunAndObtainSlope() {
		Double slope = 0d;
		slope = (this.getPositionOnY() - POSITION_Y_SUN) / (this.getPositionOnX() - POSITION_X_SUN);
		return slope;
	}
	
	public Double triangleMathematicalOrientationWithOtherPlanetAndSun(Planet pointB) {
		return ((this.getPositionOnX() - POSITION_X_SUN) * (pointB.getPositionOnY() - POSITION_Y_SUN) ) 
				- ((this.getPositionOnY()- POSITION_Y_SUN)*(pointB.getPositionOnX() - POSITION_X_SUN));
	}
	
	public Double getDistanceBetweenPlanets(Planet planetB) {
		return Math.sqrt( 
				Math.pow((planetB.getPositionOnX() - this.getPositionOnX()), 2) 
				+ Math.pow((planetB.getPositionOnY() - this.getPositionOnY()), 2) );
	}
	
	
}
