package acme.forms;

import java.io.Serializable;
import java.util.Map;

import acme.entities.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable{

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int							totalNumberOfProposedPatronages;
	int							totalNumberOfAcceptedPatronages;
	int							totalNumberOfDeniedPatronages;

	Map<Status,Stats>			statsBudgetOfStatusPatronages;
}