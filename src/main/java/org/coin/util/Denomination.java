package org.coin.util;


import lombok.*;

@Builder
@ToString
public class Denomination {
    private String description;
    private int value;
}
