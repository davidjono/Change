package org.coin.util;


import lombok.*;

@Builder
@Data
@ToString
public class Denomination {
    
    @NonNull
    private String description;
    
    @NonNull
    private int value;
}
