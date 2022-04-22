package acme.features.any.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.items.ItemType;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyItemRepository extends AbstractRepository{
	
	@Query("select i from Item i where i.itemType = :type")
	Collection<Item> findAllItem(ItemType type);
		
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
}