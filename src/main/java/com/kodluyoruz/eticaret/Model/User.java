package com.kodluyoruz.eticaret.Model;
import lombok.Data;
import javax.persistence.*;

/**
 * @author sevgidemir
 */

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;
}
