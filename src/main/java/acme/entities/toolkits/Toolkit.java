package acme.entities.toolkits;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.components.Component;
import acme.entities.tools.Tool;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Toolkit extends AbstractEntity{
	
	//Serialisation identifier
	
	protected static final long serialVersionUID = 1L;
	
	//Attributes  
	
	
	@NotBlank
	@Length(max=101)
	protected String 	name;
	
	@NotNull
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String 	code;
	
	@NotBlank
	@Length(max=101)
	protected String 	technology;
	
	@NotBlank
	@Length(max=256)
	protected String 	description;
	
	@NotNull
	@PositiveOrZero
	protected String 	retailPrice;
	
	@URL
	protected String	optionalLink;
	
	@NotNull
	@ManyToOne(optional = false)
	protected Component component;
	
	@NotNull
	@OneToOne(optional = false)
	protected Tool tool;
	

}
