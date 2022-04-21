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
import acme.framework.roles.UserRole;
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

	
//	final Comparator<UserAccount> c1=new Comparator<UserAccount>() {
//		
//		@Override
//		public int compare(final UserAccount o1, final UserAccount o2) {
//			if (o1.getId()<o2.getId()) {
//				return 0;
//			}else {
//				return 1;
//			}
//		}
//	};
	
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
//        final List<UserAccount> res2 = new ArrayList<UserAccount>();
//        res2.addAll(res);
//        Collections.sort(res2, this.c1);
        result.addAll(res);
		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		StringBuilder buffer;
        Collection<UserRole> roles;

		roles = entity.getRoles();
		buffer = new StringBuilder();
		for (final UserRole role : roles) {
			buffer.append(role.getAuthorityName());
			buffer.append(" ");
		}

		model.setAttribute("roles", buffer.toString());
		
		request.unbind(entity, model,"username");
	}
	
	

}
