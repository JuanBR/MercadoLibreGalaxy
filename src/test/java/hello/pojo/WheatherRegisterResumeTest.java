package hello.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class WheatherRegisterResumeTest {

	WheatherRegisterResume resume = new WheatherRegisterResume();

	@Test
	public void addNewWheatherRegisterDroughtDay() {
		//given
		WheatherRegister registerDroughtDay = new WheatherRegister(RelationBetweenSolarSystemObjectAndWheather.SUN_ALLIGNE_WITH_PLANETS.getWeatherDescription(), 1l);
		// when
		resume.addNewWheatherRegister(registerDroughtDay);
		resume.addNewWheatherRegister(registerDroughtDay);
		// then
		assertThat(resume.getCountDroughtDay()).isEqualTo(2);
	}
	
	@Test
	public void addNewWheatherRegisterRainyDay() {
		//given
		WheatherRegister registerRainyDay = new WheatherRegister(RelationBetweenSolarSystemObjectAndWheather.TRIANGLE_WITH_SUN_INSIDE.getWeatherDescription(), 1l);
		// when
		resume.addNewWheatherRegister(registerRainyDay);
		resume.addNewWheatherRegister(registerRainyDay);
		resume.addNewWheatherRegister(registerRainyDay);
		// then
		assertThat(resume.getCountRainyDay()).isEqualTo(3);
	}
	@Test
	public void addNewWheatherRegisterMaxIntensityRainyDay() {
		//given
		WheatherRegister registerMaxIntensityRainyDay = new WheatherRegister(RelationBetweenSolarSystemObjectAndWheather.TRIANGLE_WITH_SUN_INSIDE_MAX_PERIMETER.getWeatherDescription(), 1l);
		// when
		resume.addNewWheatherRegister(registerMaxIntensityRainyDay);
		resume.addNewWheatherRegister(registerMaxIntensityRainyDay);
		resume.addNewWheatherRegister(registerMaxIntensityRainyDay);
		// then
		assertThat(resume.getCountMaxIntensityRainyDay()).isEqualTo(3);
	}
	
	@Test
	public void addNewWheatherRegisterOptimumDay() {
		//given
		WheatherRegister registerOptimumDay = new WheatherRegister(RelationBetweenSolarSystemObjectAndWheather.ONLY_PLANETS_ALLIGNED.getWeatherDescription(), 1l);
		// when
		resume.addNewWheatherRegister(registerOptimumDay);
		resume.addNewWheatherRegister(registerOptimumDay);
		// then
		assertThat(resume.getCountOptimumDay()).isEqualTo(2);
	}
	
	@Test
	public void addNewWheatherRegisterUnknowDay() {
		//given
		WheatherRegister registerUnknowDay = new WheatherRegister(RelationBetweenSolarSystemObjectAndWheather.TRIANGLE_WITH_SUN_OUTSIDE.getWeatherDescription(), 1l);
		// when
		resume.addNewWheatherRegister(registerUnknowDay);
		resume.addNewWheatherRegister(registerUnknowDay);
		resume.addNewWheatherRegister(registerUnknowDay);
		// then
		assertThat(resume.getCountUnknowDay()).isEqualTo(3);
	}
}
