package hello.services;




import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import hello.pojo.Coordinates;

@RunWith(SpringRunner.class)
public class TwoDimensionalCartesianCoordinatesServiceImplTest {
	
	@TestConfiguration
	static class TwoDimensionalCartesianCoordinatesServiceImplTestContextConfiguration {
		@Bean
	    public TwoDimensionalCartesianCoordinatesService twoDimensionalCartesianCoordinatesService() {
			return new TwoDimensionalCartesianCoordinatesServiceImpl();
	    }
	}
	
	@Autowired
	TwoDimensionalCartesianCoordinatesService twoDimensionalCartesianCoordinatesService;
	
	List<Coordinates> points; 
	Coordinates pointP;

	@Test
	public void areAllPointAllignWithPointPVerticalAlligment(){
		//given
		List<Coordinates> points = Arrays.asList(new Coordinates(0d, 10d), new Coordinates(0d, 20d)); 
		Coordinates pointP = new Coordinates(0d, 0d);
		assertThat(twoDimensionalCartesianCoordinatesService.areAllPointAllignWithPointP(points, pointP)).isTrue();
	}
	
	@Test
	public void areAllPointAllignWithPointP(){
		//given
		List<Coordinates> points = Arrays.asList(new Coordinates(10d, 10d), new Coordinates(-10d, -10d)); 
		Coordinates pointP = new Coordinates(0d, 0d);
		// when
		// then
		assertThat(twoDimensionalCartesianCoordinatesService.areAllPointAllignWithPointP(points, pointP)).isTrue();
	}
	
	@Test
	public void areNotAllPointAllignWithPointP(){
		//given
		List<Coordinates> points = Arrays.asList(new Coordinates(10d, 20d), new Coordinates(-10d, -10d)); 
		Coordinates pointP = new Coordinates(0d, 0d);
		// when
		// then
		assertThat(twoDimensionalCartesianCoordinatesService.areAllPointAllignWithPointP(points, pointP)).isFalse();
	}
	
	@Test
	public void areAllPointAllignButNotWithPointP(){
		//given
		List<Coordinates> points = Arrays.asList(new Coordinates(-10d, 0d), new Coordinates(0d, 10d)); 
		Coordinates pointP = new Coordinates(0d, 0d);
		// when
		// then
		assertThat(twoDimensionalCartesianCoordinatesService.areAllPointAllignButNotWithPointP(points, pointP)).isTrue();
	}
	
	@Test
	public void areAllPointVerticalAllignButNotWithPointP(){
		//given
		List<Coordinates> points = Arrays.asList(new Coordinates(-10d, 0d), new Coordinates(-10d, 10d)); 
		Coordinates pointP = new Coordinates(0d, 0d);
		// when
		// then
		assertThat(twoDimensionalCartesianCoordinatesService.areAllPointAllignButNotWithPointP(points, pointP)).isTrue();
	}
	
	@Test
	public void areNotAllPointAllignButNotWithPointP(){
		//given
		List<Coordinates> points = Arrays.asList(new Coordinates(-10d, 0d), new Coordinates(-10d, 10d), new Coordinates(5d, 10d)); 
		Coordinates pointP = new Coordinates(0d, 0d);
		// when
		// then
		assertThat(twoDimensionalCartesianCoordinatesService.areAllPointAllignButNotWithPointP(points, pointP)).isFalse();
	}
	
	@Test
	public void isThePointPInsideTheTriangleABC(){
		//given
		List<Coordinates> points = Arrays.asList(new Coordinates(-4d, 2d), new Coordinates(0d, -3d), new Coordinates(3d, 3d)); 
		Coordinates pointP = new Coordinates(0d, 0d);
		// when
		// then
		assertThat(twoDimensionalCartesianCoordinatesService.isThePointPInsideTheTriangleABC(points, pointP)).isTrue();
	}
	
	@Test
	public void isNotThePointPInsideTheTriangleABC(){
		//given
		List<Coordinates> points = Arrays.asList(new Coordinates(-4d, 2d), new Coordinates(0d, -3d), new Coordinates(3d, 3d)); 
		Coordinates pointP = new Coordinates(5d, 5d);
		// when
		// then
		assertThat(twoDimensionalCartesianCoordinatesService.isThePointPInsideTheTriangleABC(points, pointP)).isFalse();
	}
	
	@Test
	public void calculateTrianglePerimeter(){
		//given
		List<Coordinates> points = Arrays.asList(new Coordinates(-1d, 0d), new Coordinates(1d, 2*Math.sqrt(3)), new Coordinates(3d, 0d)); 
		// when
		// then
		assertThat(twoDimensionalCartesianCoordinatesService.calculateTrianglePerimeter(points)).isEqualTo(12d);
	}
	
}
