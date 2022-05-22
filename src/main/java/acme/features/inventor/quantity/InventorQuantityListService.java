package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service 
public class InventorQuantityListService implements AbstractListService<Inventor, Quantity>{

    @Autowired
    protected InventorQuantityRepository repository;

    @Override
    public boolean authorise(final Request<Quantity> request) {
        assert request != null; 

        return true; 
    }

    @Override
    public Collection<Quantity> findMany(final Request<Quantity> request) {
        int toolkitId;

        toolkitId = request.getModel().getInteger("id");

//        for(final Quantity quantity: quantities) {
//            final int id=quantity.getId();
//            final Collection<Item> items=this.repository.findManyItemsByQuantityId(id);
//            result.addAll(items);
//        }

        return this.repository.findManyQuantitiesByToolkitId(toolkitId);
    }

    @Override
    public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
        assert request != null; 
        assert entity != null; 
        assert model != null; 
        
        final String name = entity.getItem().getName().trim();
        final String code = entity.getItem().getCode().trim();
        final String technology = entity.getItem().getTechnology().trim();
        final String itemType = entity.getItem().getItemType().toString().trim();
        
        model.setAttribute("name", name);
        model.setAttribute("code", code);
        model.setAttribute("technology", technology);
        model.setAttribute("itemType", itemType);

        request.unbind(entity, model, "number"); 

    }
}
