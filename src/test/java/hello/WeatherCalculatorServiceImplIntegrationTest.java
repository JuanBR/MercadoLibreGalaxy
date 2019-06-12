package hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class WeatherCalculatorServiceImplIntegrationTest {

	@TestConfiguration
	static class WeatherCalculatorImplTestContextConfiguration {
		@Bean
	    public WeatherCalculatorService weatherCalculatorService() {
			return new WeatherCalculatorServiceImpl();
	    }
	}
	
	@Autowired
	private WeatherCalculatorService weatherCalculatorService;
	 
	@MockBean
	private WheatherRegisterRepository wheatherRegisterRepository;
	 
	// write test cases here
	    
	@Before
	public void setUp() {
		WheatherRegister rainyDay = new WheatherRegister("lluvia", 1l);
	 
	    Mockito.when(wheatherRegisterRepository.findByDay(rainyDay.getDay()))
	      .thenReturn(rainyDay);
	}
	
	@Test
	public void whenValidName_thenWheatherRegisterShouldBeFound() {
		// given
		Long day = 1l;
		// when
	    WheatherRegister found = weatherCalculatorService.getWheatherRegisterByDay(day);
	    // then
	    assertThat(found.getDay()).isEqualTo(day);
	 }
	
	
	@Test
	public void showResume() {
		weatherCalculatorService.showInConsoleWheaterRegisterResumeInADecade();
	 }

}
