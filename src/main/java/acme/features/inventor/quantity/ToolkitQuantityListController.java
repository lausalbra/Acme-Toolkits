package acme.features.inventor.quantity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.quantities.Quantity;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class ToolkitQuantityListController extends AbstractController<Inventor, Quantity> {
	
	@Autowired 
	protected ToolkitQuantityListService listService;
	
	@Autowired 
	protected ToolkitQuantityShowService showService;
	
	@Autowired 
	protected ToolkitQuantityCreateService createService;
	
	@Autowired
	protected ToolkitQuantityDeleteService deleteService;
	
	@Autowired
	protected ToolkitQuantityUpdateService updateService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list-toolkit","list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("delete", this.deleteService);
		super.addCommand("update", this.updateService);
	}
	

}
