package org.coin;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A very basic Money class that represents an amount of money in a specific currency
 *
 * would need operations such as minus, addition, multiply, equals , lt (less than), gt (greater than)...
 *
 * We would also need RoundingMode for comparicon checking equals/gt/lt...
 *
 * The class is final because we don't want it extended.
 *
 */
@Builder
@Data
@Slf4j
public final class Money implements Serializable {

    @NonNull
    private final BigDecimal amount;

    @NonNull
    private final Currency currency;

    private List<Denomination> denominations = new ArrayList<>();


    /**
     * Add some Money together
     *
     * This is just a sample method..
     *
     * @param money The amount to add
     * @return Money with more money
     */
    public Money add(Money money){
        //Check that money we are adding is same currency
        if (!money.getCurrency().equals(this.currency)) throw new IllegalArgumentException("Cannot add " + money.getCurrency().toString() + " to " + this.getCurrency().toString());

        return Money.builder().amount(this.amount.add(money.amount)).currency(this.currency).build();
    }

    /**
     * Generate the lowest number of denominations for the current value
     *
     * @return
     */
    public List<Denomination> change(){

        if (denominations.isEmpty()) throw new IllegalArgumentException("Unable to determine change to provide without denominations. Please supply denominations");

        List<Denomination> changeList = new ArrayList<>();

        int remainder = amount.intValue();

        // We need to sort the denomination values with the highest value first..
        for (Denomination denomination: denominations.stream().sorted(Comparator.comparing(Denomination::getValue).reversed()).collect(Collectors.toList())) {

            log.debug("Denomination = {}", denomination);

            //Then we keep trying to get those highest value denominations from our remaining amount and add to our resulting changeList
            while (denomination.getValue() <= remainder ) {
                for (int i = 0; i < remainder / denomination.getValue(); i++) {
                    changeList.add(denomination);
                }
                remainder = remainder % denomination.getValue();
            }
        }
        return changeList;
    }


}
