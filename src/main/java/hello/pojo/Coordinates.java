package hello.pojo;

public class Coordinates {

	private Double positionOnX;
	private Double positionOnY;
	
	 
	
	public Coordinates(Double positionOnX, Double positionOnY) {
		super();
		this.positionOnX = positionOnX;
		this.positionOnY = positionOnY;
	}

	public Double getPositionOnX() {
		return positionOnX;
	}

	public Double getPositionOnY() {
		return positionOnY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((positionOnX == null) ? 0 : positionOnX.hashCode());
		result = prime * result + ((positionOnY == null) ? 0 : positionOnY.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (positionOnX == null) {
			if (other.positionOnX != null)
				return false;
		} else if (!positionOnX.equals(other.positionOnX))
			return false;
		if (positionOnY == null) {
			if (other.positionOnY != null)
				return false;
		} else if (!positionOnY.equals(other.positionOnY))
			return false;
		return true;
	}
	
	
}
