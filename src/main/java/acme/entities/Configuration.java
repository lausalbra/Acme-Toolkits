package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Configuration extends AbstractEntity{
	
	//Serialisation indentifier --------------------------------------------------------------- 
	
	protected static final long serialVersionUID = 1L;
	
	//Attributes --------------------------------------------------------------------------------
	
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}$")
	protected String defaultCurrency;
	
	@NotBlank
	protected String acceptedCurrencies;
	
	protected String strongSpamTerms;
	
	@DecimalMin(value = "0.00")
	@DecimalMax(value = "100.00")
	protected double strongSpamThreshold;
	
	protected String weakSpamTerms;
	
	@DecimalMin(value = "0.00")
	@DecimalMax(value = "100.00")
	protected double weakSpamThreshold;

}
