package acme.features.authenticated.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.items.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedItemController extends AbstractController<Authenticated, Item>{

	//Internal state 
	
	@Autowired
	protected AuthenticatedItemListService		listService;
	
	@Autowired
	protected AuthenticatedItemShowService			showService;

	
	//Constructors
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list", this.listService);
	}
	
	
}
