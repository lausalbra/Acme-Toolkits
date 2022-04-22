package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.items.ItemType;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemRepository extends AbstractRepository{
	
	@Query("select i from Item i where i.itemType = :type and i.inventor.userAccount.username = :username")
	Collection<Item> findMyItems(ItemType type, String username);
	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
	
}
