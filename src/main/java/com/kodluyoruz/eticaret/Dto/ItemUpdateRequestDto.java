package com.kodluyoruz.eticaret.Dto;
import lombok.Data;

/**
 * @author sevgidemir
 */

@Data
public class ItemUpdateRequestDto {

    private int itemId;
    private String itemNo;
    private String itemName;
    private Integer itemStock;
    private Double itemPrice;
    private int categoryId;

}
