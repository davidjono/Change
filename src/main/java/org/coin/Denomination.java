package org.coin;


import lombok.*;

/**
 * Represents the currency Denomination
 *
 * For e.g. $100 , 10000
 *
 */
@Builder
@Data
@ToString
public class Denomination {
    
    @NonNull
    private String description;
    
    @NonNull
    private int value;
}
