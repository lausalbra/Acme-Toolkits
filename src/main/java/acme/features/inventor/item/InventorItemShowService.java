package acme.features.inventor.item;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Configuration;
import acme.entities.items.Item;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorItemShowService implements AbstractShowService<Inventor, Item>{
	
	//Internal State
	
	@Autowired
	protected InventorItemRepository repository;
		
	//AbstractShowService<Inventor, Item> interface
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		 boolean result;
		 int itemId;
		 Item item;
		 
		 itemId = request.getModel().getInteger("id");
		 item = this.repository.findOneItemById(itemId);
		 result = item.getInventor().getId()==request.getPrincipal().getActiveRoleId() || item.isPublished();
		
		return result; 
	}
	
	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		
		Item result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneItemById(id);
		
		return result;
	}
	protected MoneyExchange conversion(final Money money) {
		final AuthenticatedMoneyExchangePerformService moneyExchange = new AuthenticatedMoneyExchangePerformService();
		MoneyExchange conversion = new MoneyExchange();
		final Configuration configuration = this.repository.findConfiguration();
		
		if(!money.getCurrency().equals(configuration.getDefaultCurrency())) { //money usd y lo otro eur
			conversion = this.repository.findMoneyExchageByCurrencyAndAmount(money.getCurrency(),money.getAmount());//comprobar si esta en la cache
			if(conversion == null) {//no el precio es 0 necesito esto para que no pete
				conversion = moneyExchange.computeMoneyExchange(money, configuration.getDefaultCurrency());
				this.repository.save(conversion); // y la guardo en bbdd
			}
		}else {//Si tengo euro euro no necesito conversion
			conversion.setSource(money);
			conversion.setTarget(money);
			conversion.setCurrencyTarget(configuration.getDefaultCurrency());
			conversion.setDate(new Date(System.currentTimeMillis()));		
		}
		return conversion;
	}
	
	@Override
	public void unbind (final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		final MoneyExchange conversion = this.conversion(entity.getRetailPrice());
		model.setAttribute("conversion", conversion.getTarget());
		
		final String fullname = entity.getInventor().getUserAccount().getIdentity().getFullName();
		model.setAttribute("fullname", fullname);
		final String username = entity.getInventor().getUserAccount().getUsername();
		model.setAttribute("username", username);
		
		request.unbind(entity, model, "name","itemType", "code", "technology", "description", "retailPrice", "optionalLink", "published");
	}

}
