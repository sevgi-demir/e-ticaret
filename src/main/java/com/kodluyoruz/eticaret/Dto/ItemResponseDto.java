package com.kodluyoruz.eticaret.Dto;
import lombok.Data;

/**
 * @author sevgidemir
 */

@Data
public class ItemResponseDto {

    private String itemNo;
    private String itemName;
    private Integer noOfItem;
    private Double itemPrice;
    private String categoryName;
}
