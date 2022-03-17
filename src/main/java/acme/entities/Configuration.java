package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	protected String defaultCurrency;
	
	@NotBlank
	protected String acceptedCurrencies;
	
	protected String strongSpamTerms;
	
	@NotNull
	protected Double strongSpamThreshold;
	
	protected String weakSpamTerms;
	
	@NotNull
	protected Double weakSpamThreshold;

}
