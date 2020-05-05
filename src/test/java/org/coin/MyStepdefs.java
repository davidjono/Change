package org.coin;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.coin.util.Denomination;

import java.util.*;

@Slf4j
public class MyStepdefs {


    org.coin.util.Currency currency;

    @Given("I have a currency called {string} with the following denominations")
    public void iHaveACurrencyCalledWithTheFollowingDenominations(String currencyCode, DataTable dataTable) {

        List<Denomination> denominationList = new ArrayList<>();

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        log.info("Rows = {}", rows);

        for (Map<String, String> columns : rows) {

            log.info("columns , description[{}] and value[{}]" ,columns.get("description"), columns.get("value"));

            denominationList.add(Denomination.builder().description(columns.get("description")).value(Integer.parseInt(columns.get("value"))).build());

        }

        currency = org.coin.util.Currency.builder().currency(Currency.getInstance(currencyCode)).denominations(denominationList).build();


        final Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();

        log.info("Currency = {}", currency);




    }

    @And("I request smallest number of bills and coins for {int}")
    public void iRequestSmallestNumberOfBillsAndCoinsFor(int balance) {

        List<Denomination> change = currency.change(balance);
        log.info("Change = {}", change);


    }
}
