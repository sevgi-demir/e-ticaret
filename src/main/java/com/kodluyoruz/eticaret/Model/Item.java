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
    private int itemId;

    @Column(name = "itemNo")
    private String itemNo;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "itemStock")
    private Integer itemStock;

    @Column(name = "itemPrice")
    private Double itemPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
