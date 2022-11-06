package com.kodluyoruz.eticaret.Repository;
import com.kodluyoruz.eticaret.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sevgidemir
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
