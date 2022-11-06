package com.kodluyoruz.eticaret.Dto;
import lombok.Data;

/**
 * @author sevgidemir
 */

@Data
public class ItemRequestDto {

    private String itemNo;
    private String itemName;
    private Integer noOfItem;
    private Double itemPrice;
    private int categoryId;
}
