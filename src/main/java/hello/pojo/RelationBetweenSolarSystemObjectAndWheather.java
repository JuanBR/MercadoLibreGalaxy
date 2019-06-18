package hello;

public enum RelationBetweenSolarSystemObjectAndWheather {

	ONLY_PLANETS_ALLIGNED("optimo"),
    SUN_ALLIGNE_WITH_PLANETS("sequia"),
    TRIANGLE_WITH_SUN_INSIDE("lluvia"),
    TRIANGLE_WITH_SUN_INSIDE_MAX_PERIMETER("lluvia - max intensidad"),
    UNKNOWN("unknwon");

    private String weatherDescription;

    RelationBetweenSolarSystemObjectAndWheather(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }
	
}
