package hello.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SolarSystemTest {
	
	private SolarSystem mySolarSystem;
	
	@Before
	public void setUp() {
		//given
		Planet myPlanet1 = new Planet("myPlanet1", 500d, 90d , -90d);
		Planet myPlanet2 = new Planet("myPlanet2", 100d, 90d , -180d);
		List<Planet> planets = Arrays.asList(myPlanet1,myPlanet2);
		mySolarSystem = new SolarSystem(planets, "mySolarSystem");
	}
	
	@Test
	public void moveOneDay() {
		// when
		mySolarSystem.moveOneDay();
		// then
		assertThat(mySolarSystem.getPlanets().get(0).getCoordinates().getPositionOnX()).isEqualTo(500d);
		assertThat(mySolarSystem.getPlanets().get(0).getCoordinates().getPositionOnY()).isEqualTo(0d);
		assertThat(mySolarSystem.getPlanets().get(1).getCoordinates().getPositionOnX()).isEqualTo(100d);
		assertThat(mySolarSystem.getPlanets().get(1).getCoordinates().getPositionOnY()).isEqualTo(0d);
	}
	
	@Test
	public void hasReturnedToOriginalPosition() {
		// when
		mySolarSystem.moveOneDay();
		mySolarSystem.moveOneDay();
		mySolarSystem.moveOneDay();
		mySolarSystem.moveOneDay();
		// then
		assertThat(mySolarSystem.returnedToOriginalPosition()).isTrue();
	}

	@Test
	public void hasNotReturnedToOriginalPosition() {
		// when
		mySolarSystem.moveOneDay();
		mySolarSystem.moveOneDay();
		// then
		assertThat(mySolarSystem.returnedToOriginalPosition()).isFalse();
	}

}
