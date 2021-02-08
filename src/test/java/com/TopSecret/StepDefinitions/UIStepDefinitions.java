package com.TopSecret.StepDefinitions;

import com.TopSecret.Pages.HomePage;
import com.TopSecret.Utilities.ConfigurationReader;
import com.TopSecret.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UIStepDefinitions {
    private HomePage homePage;

    //dependency injection with picoContainer
    public UIStepDefinitions(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("User navigated to ToDo application")
    public void user_navigated_to_ToDo_application() {
        String url = System.getProperty("base.url") != null ? System.getProperty("base.url") : ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @Given("Empty ToDo list")
    public void emptyToDoList() {
        Assert.assertTrue(homePage.isListEmpty());
    }

    @When("I write {string} to TextBox and press enter")
    public void iWriteToTextBoxAndPressEnter(String item) {
        homePage.writeToTextBoxAndHitEnter(item);

    }

    @Then("I should see {string} item in ToDo list")
    public void iShouldSeeItemInToDoList(String item) {
        Assert.assertEquals(item, homePage.getFirstItemText());

    }

    @Given("ToDo list with {string} item")
    public void todoListWithItem(String item) {
        homePage.writeToTextBoxAndHitEnter(item);
    }

    @Then("I should see {string} item inserted to ToDo list below {string}")
    public void iShouldSeeItemInsertedToToDoListBelow(String secondItem, String firstItem) {
        Assert.assertTrue(homePage.findItemIndex(secondItem) > homePage.findItemIndex(firstItem));
    }

    @Then("I should see {string} item marked as DONE")
    public void iShouldSeeItemMarkedAsDONE(String item) {
        Assert.assertTrue(homePage.isDone(item));
    }

    @When("I click on {string} next to {string} item")
    public void iClickOnNextToItem(String webElement, String item) {
        homePage.clickElementOfItem(webElement, item);
    }

    @Given("ToDo list with marked {string} item")
    public void todoListWithMarkedItem(String item) {
        homePage.writeToTextBoxAndHitEnter(item);
        homePage.clickElementOfItem("checkBox", item);
    }

    @Then("I should see {string} item marked as UNDONE")
    public void iShouldSeeItemMarkedAsUNDONE(String item) {
        Assert.assertTrue(homePage.isUnDone(item));
    }

    @Then("List should be empty")
    public void listShouldBeEmpty() {
        Assert.assertTrue(homePage.isListEmpty());
    }

    @Given("ToDo list with {string} and {string} item in order")
    public void todoListWithAndItemInOrder(String item1, String item2) {
        homePage.writeToTextBoxAndHitEnter(item1);
        homePage.writeToTextBoxAndHitEnter(item2);
    }
}
