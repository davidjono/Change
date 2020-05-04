package org.coin.util;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class Currency {

    private java.util.Currency currency;
    private List<Denomination> denominations;



}
