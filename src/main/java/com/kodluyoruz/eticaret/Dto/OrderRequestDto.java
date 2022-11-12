package com.kodluyoruz.eticaret.Dto;
import lombok.Data;

/**
 * @author sevgidemir
 */

@Data
public class OrderRequestDto {

    private int itemId;
    private int numberOfOrder;
    private int userId;

}
