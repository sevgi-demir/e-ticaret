package com.kodluyoruz.eticaret.Model;
import lombok.Data;
import javax.persistence.*;

/**
 * @author sevgidemir
 */

@Entity
@Table(name = "items")
@Data
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "itemNo")
    private String itemNo;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "noOfItem")
    private Integer noOfItem;

    @Column(name = "itemPrice")
    private Double itemPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
