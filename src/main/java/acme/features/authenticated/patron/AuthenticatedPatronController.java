package acme.features.authenticated.patron;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;
import acme.roles.Patron;

public class AuthenticatedPatronController extends AbstractController<Authenticated,Patron>{
	
	@Autowired
	protected AuthenticatedPatronCreateService	createService;

	@Autowired
	protected AuthenticatedPatronUpdateService	updateService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateService);
	}
}