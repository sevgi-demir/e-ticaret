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

    @Column(name = "userId")
    private int userId;

    @Column(name = "itemId")
    private int itemId;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "noOfOrder")
    private int noOfOrder;


}
