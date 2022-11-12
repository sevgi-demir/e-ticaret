package com.kodluyoruz.eticaret.Dto;
import com.kodluyoruz.eticaret.Annotations.ItemAnnotations.ItemPropertiesRules;
import com.kodluyoruz.eticaret.Annotations.ItemAnnotations.ItemRules;
import lombok.Data;

/**
 * @author sevgidemir
 */

@Data
@ItemPropertiesRules
public class ItemRequestDto {


    private String itemNo;

    @ItemRules
    private String itemName;
    private Integer itemStock;
    private Double itemPrice;
    private int categoryId;
}
