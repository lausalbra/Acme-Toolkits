package acme.features.administrator.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.items.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
public class AdministratorItemController extends AbstractController<Administrator, Item>{

	//Internal state 
	
	@Autowired
	protected AdministratorItemListService		listService;
	
	@Autowired
	protected AdministratorItemShowService			showService;

	
	//Constructors
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list", this.listService);
	}
	
	
}
