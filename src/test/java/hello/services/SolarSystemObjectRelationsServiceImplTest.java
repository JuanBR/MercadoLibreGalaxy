package hello.services;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.boot.model.source.spi.AnyDiscriminatorSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import hello.pojo.Coordinates;
import hello.pojo.Planet;
import hello.pojo.SolarSystem;
import hello.utils.FactorySolarSystem;

@RunWith(SpringRunner.class)
public class SolarSystemObjectRelationsServiceImplTest {

	
	@TestConfiguration
	static class SolarSystemObjectRelationsServiceImplTestContextConfiguration {
		@Bean
	    public SolarSystemObjectRelationsService solarSystemObjectRelationsService() {
			return new SolarSystemObjectRelationsServiceImpl();
	    }
	}
	
	@Autowired
	private SolarSystemObjectRelationsService solarSystemObjectRelationsService;
	
	@MockBean
	private TwoDimensionalCartesianCoordinatesService twoDimensionalCartesianCoordinatesService;
	
	private SolarSystem mySolarSystem;
	
	@Before
	public void setUp() {
		//given
		Planet myPlanet1 = new Planet("myPlanet1", 500d, 90d , -90d);
		Planet myPlanet2 = new Planet("myPlanet2", 100d, 90d , 45d);
		Planet myPlanet3 = new Planet("myPlanet3", 100d, 90d , -180d);
		List<Planet> planets = Arrays.asList(myPlanet1, myPlanet2, myPlanet3);
		mySolarSystem = new SolarSystem(planets, "MercadoLibre");
	}
	
	
	@Test
	public void allPlanetsAreAllignWithTheSun(){
		given(twoDimensionalCartesianCoordinatesService.areAllPointAllignWithPointP(Mockito.<Coordinates>anyList(), Mockito.any(Coordinates.class))).willReturn(true);
		assertThat(solarSystemObjectRelationsService.allPlanetsAreAllignWithTheSun(mySolarSystem)).isTrue();
	}
	
	@Test
	public void notAllPlanetsAreAllignWithTheSun(){
		given(twoDimensionalCartesianCoordinatesService.areAllPointAllignWithPointP(Mockito.<Coordinates>anyList(), Mockito.any(Coordinates.class))).willReturn(false);
		assertThat(solarSystemObjectRelationsService.allPlanetsAreAllignWithTheSun(mySolarSystem)).isFalse();
	}
	
	@Test
	public void onlyPlanetsAreAlligned(){
		given(twoDimensionalCartesianCoordinatesService.areAllPointAllignButNotWithPointP(Mockito.<Coordinates>anyList(), Mockito.any(Coordinates.class))).willReturn(true);
		assertThat(solarSystemObjectRelationsService.onlyPlanetsAreAlligned(mySolarSystem)).isTrue();
	}
	
	@Test
	public void notOnlyPlanetsAreAlligned(){
		given(twoDimensionalCartesianCoordinatesService.areAllPointAllignButNotWithPointP(Mockito.<Coordinates>anyList(), Mockito.any(Coordinates.class))).willReturn(false);
		assertThat(solarSystemObjectRelationsService.onlyPlanetsAreAlligned(mySolarSystem)).isFalse();
	}
	
	@Test
	public void isSunInsideOfTheTriangle(){
		given(twoDimensionalCartesianCoordinatesService.isThePointPInsideTheTriangleABC(Mockito.<Coordinates>anyList(), Mockito.any(Coordinates.class))).willReturn(true);
		assertThat(solarSystemObjectRelationsService.isSunInsideOfTheTriangle(mySolarSystem)).isTrue();
	}
	
	@Test
	public void isNotSunInsideOfTheTriangle(){
		given(twoDimensionalCartesianCoordinatesService.isThePointPInsideTheTriangleABC(Mockito.<Coordinates>anyList(), Mockito.any(Coordinates.class))).willReturn(false);
		assertThat(solarSystemObjectRelationsService.isSunInsideOfTheTriangle(mySolarSystem)).isFalse();
	}
	
	@Test
	public void calculateTrianglePerimeter(){
		Double perimeter = 12d;
		given(twoDimensionalCartesianCoordinatesService.calculateTrianglePerimeter(Mockito.<Coordinates>anyList())).willReturn(perimeter);
		assertThat(solarSystemObjectRelationsService.calculateTrianglePerimeter(mySolarSystem)).isEqualTo(perimeter);
	}
	
	@Test
	public void getMaxTrianglePerimeter(){
		Double perimeter = 12d;
		given(twoDimensionalCartesianCoordinatesService.calculateTrianglePerimeter(Mockito.<Coordinates>anyList())).willReturn(perimeter);
		given(twoDimensionalCartesianCoordinatesService.isThePointPInsideTheTriangleABC(Mockito.<Coordinates>anyList(), Mockito.any(Coordinates.class))).willReturn(true);
		assertThat(solarSystemObjectRelationsService.getMaxTrianglePerimeter(mySolarSystem)).isEqualTo(perimeter);
	}
}
