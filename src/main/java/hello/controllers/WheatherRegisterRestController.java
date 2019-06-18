package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WheatherRegisterRestController {

	@Autowired
    private WeatherCalculatorService weatherCalculatorService;
 
    @GetMapping("/wheatherRegisters")
    public List<WheatherRegister> getAllWheatherRegisters() {
        return weatherCalculatorService.getAllWheatherRegisters();
    }
    
    @GetMapping("/wheather")
    public WheatherRegister getWheather(@RequestParam(value="day", defaultValue="1") Long day) {
    	return weatherCalculatorService.getWheatherRegisterByDay(day);
    }
}
