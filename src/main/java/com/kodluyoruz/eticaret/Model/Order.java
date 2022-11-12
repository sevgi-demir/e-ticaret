package com.kodluyoruz.eticaret.Model;
import lombok.Data;
import javax.persistence.*;

/**
 * @author sevgidemir
 */

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "itemId")
    private int itemId;

    @Column(name = "numberOfOrder")
    private int numberOfOrder;

}
