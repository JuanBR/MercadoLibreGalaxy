package hello.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CartesianTriangleTest {

	 
	private final Coordinates center = new Coordinates(0d, 0d);
	
	@Test
	public void thePointPIsInsideTheTriangleABC() {
		// given
		CartesianTriangle cartesianTrianglePointPInside  = new CartesianTriangle(new Coordinates(-4d, 2d), new Coordinates(1d, -3d), new Coordinates(3d, 3d));
        // when
        // then
        assertThat(cartesianTrianglePointPInside.isThePointPInsideTheTriangleABC(center)).isTrue();
	}
	
	@Test
	public void thePointPIsOutsideTheTriangleABC() {
		// given
		CartesianTriangle cartesianTrianglePointPOutside = new CartesianTriangle(new Coordinates(4d, 4d), new Coordinates(5d, 5d), new Coordinates(6d, 4d));
        // when
        // then
        assertThat(cartesianTrianglePointPOutside.isThePointPInsideTheTriangleABC(center)).isFalse();
	}
	
	@Test
	public void getPerimeter() {
		// given
		CartesianTriangle cartesianTriangle = new CartesianTriangle(new Coordinates(-1d, 0d), new Coordinates(1d, 2*Math.sqrt(3)), new Coordinates(3d, 0d));
        // when
        // then
        assertThat(cartesianTriangle.getPerimeter()).isEqualTo(12d);
	}
	
}
