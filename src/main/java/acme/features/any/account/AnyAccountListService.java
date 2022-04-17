package acme.features.any.account;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyAccountListService implements AbstractListService<Any, UserAccount>{
	@Autowired
	protected AnyAccountRepository repository;
	 
	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;
		Collection<UserAccount> result;

        result = this.repository.findUserAccounts();
        for (final UserAccount userAccount:result) {
        	userAccount.getRoles().forEach(r -> {});
        }
        final Set<UserAccount> res = new HashSet<UserAccount>();
        res.addAll(result);
        result.clear();
        result.addAll(res);
		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final boolean patron = entity.getRoles().stream().anyMatch(r->r.toString().contains("Patron"));
		final boolean inventor = entity.getRoles().stream().anyMatch(r->r.toString().contains("Inventor"));
		
		model.setAttribute("ua", 22);
		if (inventor) {
			if (patron) {
				model.setAttribute("roles", "Patron, Inventor");
			}else {model.setAttribute("roles", "Inventor");}
		}else {if(patron){model.setAttribute("roles", "Patron");}}
//		model.setAttribute("roles", entity.getRoles());
		
		request.unbind(entity, model,"username");
	}
	
	

}
