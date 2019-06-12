package hello;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(WheatherRegisterRestController.class)
public class WheatherRegisterRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	 
	@MockBean
	private WeatherCalculatorService weatherCalculatorService;
	 
	// write test cases here
	
	@Test
	public void givenWheathers_whenGetAllWheatherRegisters_thenReturnJsonArray() throws Exception {
    	WheatherRegister rainyDay = new WheatherRegister("lluvia", 1l);
	 
	    List<WheatherRegister> allDays = Arrays.asList(rainyDay);
	 
	    given(weatherCalculatorService.getAllWheatherRegisters()).willReturn(allDays);
	 
	    mvc.perform(get("/api/wheatherRegisters")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].day", is(rainyDay.getDay())));
	}
	
	@Test
	public void givenDay_whenGetWheather_thenReturnJson() throws Exception {
		Long day = 1l;
    	WheatherRegister rainyDay = new WheatherRegister("lluvia", day);
	 
	    given(weatherCalculatorService.getWheatherRegisterByDay(day)).willReturn(rainyDay);
	 
	    mvc.perform(get("/api/wheather?day=1")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.day", is(rainyDay.getDay().intValue())));
	}
	
}
