package steps;

import base.WebDriverSingleton;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enumerators.BananaTableColumn;
import pages.BananaPage;

import java.util.Map;

import static hooks.TaggedHooks.getScenario;

public class BananaSteps {
    private BananaPage bananaPage;

    @Given("^I am on banana shop page$")
    public void iAmOnBananaShopPage() {
        getBananaPage().openPage();
        getScenario().write(WebDriverSingleton.getInstance().getDriver().getCurrentUrl());
    }

    @When("^I have chosen 1 banana$")
    public void iHaveChosenBanana() {
        getBananaPage().enterBananaAmount("1");
        getBananaPage().submitBananaAmount();
    }

    private BananaPage getBananaPage() {
        if (bananaPage == null) {
            bananaPage = new BananaPage();
        }
        return bananaPage;
    }

    @Then("^values in table are following$")
    public void followingPricesAreDisplayed(DataTable table) {
        Map<BananaTableColumn, String> tableMap = table.asMap(BananaTableColumn.class, String.class);
        getBananaPage().checkTableValue(tableMap.get(BananaTableColumn.TOTAL_PRICE), BananaTableColumn.TOTAL_PRICE);
        getBananaPage().checkTableValue(tableMap.get(BananaTableColumn.DISCOUNT), BananaTableColumn.DISCOUNT);
    }

    @And("^price for one banana is 1.5$")
    public void priceForOneBananaIs() {
        System.out.println("Nothing here");
    }
}
