package com.kodluyoruz.eticaret.Repository;
import com.kodluyoruz.eticaret.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sevgidemir
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(int id);
}
