package hello;

public class WheatherRegisterResume {
	Long countDroughtDay;
	Long countRainyDay;
	Long countMaxIntensityRainyDay;
	Long countOptimumDay;
	Long countUnknowDay;
	
	
	public Long getCountDroughtDay() {
		return countDroughtDay;
	}
	public Long getCountRainyDay() {
		return countRainyDay;
	}
	public Long getCountMaxIntensityRainyDay() {
		return countMaxIntensityRainyDay;
	}
	public Long getCountOptimumDay() {
		return countOptimumDay;
	}
	public Long getCountUnknowDay() {
		return countUnknowDay;
	}
	
	public WheatherRegisterResume() {
		super();
		countDroughtDay = 0l;
		countRainyDay = 0l;
		countMaxIntensityRainyDay = 0l;
		countOptimumDay = 0l;
		countUnknowDay = 0l;
	}
	
	public void addNewWheatherRegister(WheatherRegister register) {
		countDroughtDay += register.getWheatherDescription().equals(RelationBetweenSolarSystemObjectAndWheather.SUN_ALLIGNE_WITH_PLANETS.getWeatherDescription()) ? 1 : 0;
		countRainyDay += register.getWheatherDescription().equals(RelationBetweenSolarSystemObjectAndWheather.TRIANGLE_WITH_SUN_INSIDE.getWeatherDescription()) ? 1 : 0;
		countMaxIntensityRainyDay += register.getWheatherDescription().equals(RelationBetweenSolarSystemObjectAndWheather.TRIANGLE_WITH_SUN_INSIDE_MAX_PERIMETER.getWeatherDescription()) ? 1 : 0;
		countOptimumDay += register.getWheatherDescription().equals(RelationBetweenSolarSystemObjectAndWheather.ONLY_PLANETS_ALLIGNED.getWeatherDescription()) ? 1 : 0;
		countUnknowDay += register.getWheatherDescription().equals(RelationBetweenSolarSystemObjectAndWheather.UNKNOWN.getWeatherDescription()) ? 1 : 0;
	}
	
	public void showInConsole() {
		System.out.printf("\n=========================================");
		System.out.printf("\n Count Drought Day: %d  %n", countDroughtDay);
		System.out.printf("\n Count Rainy Day: %d  %n", countRainyDay);
		System.out.printf("\n Count Max Intensity Rainy Day: %d  %n", countMaxIntensityRainyDay);
		System.out.printf("\n Count Optimum Day: %d  %n", countOptimumDay);
		System.out.printf("\n Count Unknow Day: %d  %n", countUnknowDay);
		System.out.printf("\n=========================================");
	}

}
