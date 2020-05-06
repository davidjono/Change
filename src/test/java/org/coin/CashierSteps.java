package org.coin;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
public class CashierSteps {


    private List<Denomination> change = new ArrayList<>();

    private Money amount;

    @Given("I have a currency called {string} with the following denominations and an amount in smallest units of {string}")
    public void iHaveACurrencyCalledWithTheFollowingDenominationsAndAnAmountInSmallestUnitsOf(String currencyCode, String amountString, DataTable dataTable) {

        List<Denomination> denominations = new ArrayList<>();

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        log.debug("Rows = {}", rows);

        for (Map<String, String> columns : rows) {
            denominations.add(Denomination.builder().description(columns.get("description")).value(Integer.parseInt(columns.get("value"))).build());
        }

        amount = Money.builder().currency(Currency.getInstance(currencyCode)).amount(new BigDecimal(amountString)).denominations(denominations).build();

        log.info("Amount = " + amount);

        Assert.assertEquals(amount.getAmount(), new BigDecimal(amountString));


    }

    @And("I request smallest number of bills and coins")
    public void iRequestSmallestNumberOfBillsAndCoins() {

        change = amount.change();
        Assert.assertTrue("Got some change " , !change.isEmpty());

    }

    @Then("I should have the following change")
    public void iShouldHaveTheFollowingChange(DataTable dataTable) {

        List<Denomination> expectedChange = new ArrayList<>();

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            expectedChange.add(Denomination.builder().description(columns.get("description")).value(Integer.parseInt(columns.get("value"))).build());
        }

        Assert.assertArrayEquals("Expected change does not match what I received",expectedChange.toArray(), change.toArray());
    }


    @Then("I add {string} to that amount and I should have {string}")
    public void iAddToThatAmount(String amountString, String resultString) {

        Money moneyToAdd = Money.builder().amount(new BigDecimal(amountString)).currency(amount.getCurrency()).build();

        final Money actualResult = amount.add(moneyToAdd);
        final Money expectedResult = Money.builder().amount(new BigDecimal(resultString)).currency(amount.getCurrency()).build();

        log.info("Result = " + actualResult);

        Assert.assertEquals(expectedResult, actualResult);


    }
}
