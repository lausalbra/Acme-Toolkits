package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.items.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolkitController extends AbstractController<Inventor, Item>{
	
	//Internal state 
	
	@Autowired
	protected InventorToolkitListService	listService;
	
	@Autowired
	protected InventorToolkitShowService	showService;
	
}
