package hello;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherCalculatorServiceImpl implements WeatherCalculatorService {

	@Autowired
    private WheatherRegisterRepository wheatherRegisterRepository;
 
    @Override
    public WheatherRegister getWheatherRegisterByDay(Long day) {
        return wheatherRegisterRepository.findByDay(day);
    }

	@Override
	public List<WheatherRegister> getAllWheatherRegisters() {
		return wheatherRegisterRepository.findAll();
	}
	
	private void saveWheatherRegister(SolarSystem solarSystem) {
		WheatherRegister newRegister = new WheatherRegister(solarSystem.getWeatherDescription(), solarSystem.getCurrentDay());
		wheatherRegisterRepository.save(newRegister);
	}
	
	@Override
	public void populateDataBaseWithWheatherInADecade() {
	    LocalDate today = LocalDate.now();
	    LocalDate aYearAfter = today.plusYears(10);	 
	    SolarSystem mercadoLibreSolarSystem = new SolarSystem();

	    Long daysInADecade = ChronoUnit.DAYS.between(today, aYearAfter);
	    
	    for (Long day = 1l ; day <= daysInADecade; day++) {
	    	mercadoLibreSolarSystem.setSolarSystemToAnSpecificDay(day);
	    	saveWheatherRegister(mercadoLibreSolarSystem);
	    }
	    
	}
	
	@Override
	public void showInConsoleWheaterRegisterResumeInADecade() {
		 LocalDate today = LocalDate.now();
		 LocalDate aYearAfter = today.plusYears(10);	 
		 SolarSystem mercadoLibreSolarSystem = new SolarSystem();
		 WheatherRegisterResume registerResume = new WheatherRegisterResume();
		 
		 Long daysInADecade = ChronoUnit.DAYS.between(today, aYearAfter);
		    
		 for (Long day = 1l ; day <= daysInADecade; day++) {
			mercadoLibreSolarSystem.setSolarSystemToAnSpecificDay(day);;
			System.out.printf("Day: %d - Wheater: %s  %n", day, mercadoLibreSolarSystem.getWeatherDescription());
		    WheatherRegister register = new WheatherRegister(mercadoLibreSolarSystem.getWeatherDescription(), mercadoLibreSolarSystem.getCurrentDay());
		    registerResume.addNewWheatherRegister(register);
		 }
		 registerResume.showInConsole();
		
		
	}
	
}
