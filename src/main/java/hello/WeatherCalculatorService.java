package hello;

import java.util.List;

public interface WeatherCalculatorService {

	WheatherRegister getWheatherRegisterByDay(Long day);

	List<WheatherRegister> getAllWheatherRegisters();

	void populateDataBaseWithWheatherInADecade();

	void showInConsoleWheaterRegisterResumeInADecade();


}
