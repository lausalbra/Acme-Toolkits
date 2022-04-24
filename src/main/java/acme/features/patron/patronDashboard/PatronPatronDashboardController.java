package acme.features.patron.patronDashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.forms.PatronDashboard;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
@RequestMapping("/patron/patron-dashboard/")
public class PatronPatronDashboardController extends AbstractController<Patron, PatronDashboard>{
	  
	  @Autowired
	  protected PatronPatronDashboardShowService    showService;
	  
	  @PostConstruct
	  protected void initialise() {
	        super.addCommand("show", this.showService);
	    }

}
