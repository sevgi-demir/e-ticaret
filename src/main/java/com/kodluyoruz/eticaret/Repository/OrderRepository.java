package com.kodluyoruz.eticaret.Repository;
import com.kodluyoruz.eticaret.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sevgidemir
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
