package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Configuration;
import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemRepository extends AbstractRepository{
	
	@Query("select i from Item i where i.inventor.userAccount.username = :username")
	Collection<Item> findMyItems(String username);
	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);

	@Query("select i from Inventor i where i.id = :id")
	Inventor findOneInventorById(int id);

	@Query("select i from Item i where i.code = :code")
	Item findOneItemByCode(String code);
	
	@Query("select c from Configuration c")
	Configuration findConfiguration();
	
	
}
