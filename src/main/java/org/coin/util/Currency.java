package org.coin.util;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Builder
@ToString
public class Currency {

    @NonNull
    private java.util.Currency currency;

    @NonNull
    private List<Denomination> denominations;

    public List<Denomination> change(int value){

        System.out.println("Value = " + value);
        List<Denomination> denominationList = new ArrayList<>();


        AtomicInteger fred = new AtomicInteger();
        fred.set(value);

        denominations.stream().sorted(Comparator.comparing(Denomination::getValue).reversed()).collect(Collectors.toList()).forEach(e -> {

            if (fred.get() >= e.getValue()){
                fred.set(fred.get()%e.getValue());
                denominationList.add(e);
            }
        });

        return denominationList;

    }
}
