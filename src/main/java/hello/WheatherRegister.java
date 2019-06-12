package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WheatherRegister")
public class WheatherRegister {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 private String wheatherDescription;
	 
	 private Long day;

	
	 
	public WheatherRegister() {
		super();
	}

	public WheatherRegister(String wheatherDescription, Long day) {
		super();
		this.wheatherDescription = wheatherDescription;
		this.day = day;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getWheatherDescription() {
		return wheatherDescription;
	}



	public void setWheatherDescription(String wheatherDescription) {
		this.wheatherDescription = wheatherDescription;
	}



	public Long getDay() {
		return day;
	}



	public void setDay(Long day) {
		this.day = day;
	}
	 
	 
	 
}
