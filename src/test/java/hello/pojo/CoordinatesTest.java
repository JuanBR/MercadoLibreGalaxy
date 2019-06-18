package hello.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CoordinatesTest {

	@Test
	public void isEqual() {
		//given
		Coordinates cor1 = new Coordinates(10d,10d);
		Coordinates cor2 = new Coordinates(10d,10d);
		// when
		// then
        assertThat(cor1.equals(cor2)).isTrue();
	}
	
	@Test
	public void isNotEqual() {
		//given
		Coordinates coor1 = new Coordinates(11d,10d);
		Coordinates coor2 = new Coordinates(10d,10d);
		Coordinates coor3 = new Coordinates(10d,11d);
		Coordinates coor4 = new Coordinates(12d,12d);
		// when
		// then
		assertThat(coor1.equals(coor2)).isFalse();
		assertThat(coor1.equals(null)).isFalse();
		assertThat(coor2.equals(coor3)).isFalse();
		assertThat(coor1.equals(coor4)).isFalse();
	}
}
