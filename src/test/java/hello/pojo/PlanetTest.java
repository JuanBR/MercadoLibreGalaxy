package hello.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PlanetTest {
	
	Planet myPlanet;
	
	@Before
	public void setUp() {
		//given
		myPlanet = new Planet("myPlanet", 500d, 90d , -90d);
	}

	
	@Test
	public void getCoordinates() {
		// when
		// then
        assertThat(myPlanet.getCoordinates().getPositionOnX()).isEqualTo(0d);
        assertThat(myPlanet.getCoordinates().getPositionOnY()).isEqualTo(500d);
	}
	
	@Test
	public void moveOnDay() {
		// when
		myPlanet.moveOnDay();
		// then
		assertThat(myPlanet.getCoordinates().getPositionOnX()).isEqualTo(500d);
		assertThat(myPlanet.getCoordinates().getPositionOnY()).isEqualTo(0d);
	}
	
	@Test
	public void hasReturnedToOriginalPosition() {
		// when
		myPlanet.moveOnDay();
		myPlanet.moveOnDay();
		myPlanet.moveOnDay();
		myPlanet.moveOnDay();
		// then
		assertThat(myPlanet.returnedToOriginalPosition()).isTrue();
	}
	
	@Test
	public void hasNotReturnedToOriginalPosition() {
		// when
		myPlanet.moveOnDay();
		myPlanet.moveOnDay();
		// then
		assertThat(myPlanet.returnedToOriginalPosition()).isFalse();
	}
}
