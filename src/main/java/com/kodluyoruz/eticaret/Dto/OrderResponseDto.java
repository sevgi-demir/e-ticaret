package com.kodluyoruz.eticaret.Dto;
import lombok.Data;

/**
 * @author sevgidemir
 */

@Data
public class OrderResponseDto {

    private int userId;
    private int itemId;
    private String userEmail;
    private String itemName;
    private String name;
    private String mobile;
}
