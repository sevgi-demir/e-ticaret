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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;
}
