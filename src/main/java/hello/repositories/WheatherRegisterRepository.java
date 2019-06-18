package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheatherRegisterRepository extends JpaRepository<WheatherRegister, Long>{
	
	public WheatherRegister findByDay(Long day);

}
