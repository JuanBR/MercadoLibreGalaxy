package hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WheatherRegisterRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private WheatherRegisterRepository wheatherRegisterRepository;
    
    // write test cases here
    

    @Test
    public void whenFindByDay_thenReturnWheatherRegister() {
    	// given
    	WheatherRegister rainyDay = new WheatherRegister("lluvia", 1l);
        entityManager.persist(rainyDay);
        entityManager.flush();
     
        // when
        WheatherRegister found = wheatherRegisterRepository.findByDay(rainyDay.getDay());
     
        // then
        assertThat(found.getDay()).isEqualTo(rainyDay.getDay());
    }
    
    
    
    
    
}
