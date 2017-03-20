package com.ander.single.step_definition;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;

public class GoogleSteps {
    private GooglePage page;

    public GoogleSteps(WebDriver driver) {
        page = new GooglePage(driver);
    }

    @Given("I type query as '$keyword'")
    public void searchGoogle(@Named("keyword") String keyword) {
        page.searchOnGoogle(keyword);
    }

    @When("I submit")
    public void submit() throws Exception {
        page.submitSearch();
    }

    @Then("I should see title '$title'")
    public void titleShouldContain(@Named("title") String keyword) {
        Assert.assertEquals(keyword, page.getTitle());
        page.quitDriver();
    }
}
