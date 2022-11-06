package com.kodluyoruz.eticaret.Model;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

/**
 * @author sevgidemir
 */

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "category_name")
    private String categoryName;


    @OneToMany(mappedBy = "category")
    private List<Item> items;
}
