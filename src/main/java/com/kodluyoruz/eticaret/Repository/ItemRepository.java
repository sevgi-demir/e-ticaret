package com.kodluyoruz.eticaret.Repository;
import com.kodluyoruz.eticaret.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sevgidemir
 */
public interface ItemRepository  extends JpaRepository<Item, Integer> {


}
