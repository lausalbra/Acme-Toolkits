package acme.features.authenticated.chirp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.chirps.Chirp;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedChirpController extends AbstractController<Authenticated, Chirp>{
	
	  @Autowired
	    protected AuthenticatedChirpListRecentService    listRecentService;
	  
	  @PostConstruct
	    protected void initialise() {
	        super.addCommand("list-recent", "list", this.listRecentService);
	    }

}
