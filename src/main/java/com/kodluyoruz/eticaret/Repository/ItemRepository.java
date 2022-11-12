package com.kodluyoruz.eticaret.Repository;
import com.kodluyoruz.eticaret.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * @author sevgidemir
 */
public interface ItemRepository  extends JpaRepository<Item, Integer> {


    Optional<Item> findById(int id);

    Item findByItemName(String itemName);

    List<Item> getAllByCategory_CategoryId(long id);


}
