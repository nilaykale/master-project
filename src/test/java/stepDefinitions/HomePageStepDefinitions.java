package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.HomePage;

public class HomePageStepDefinitions extends BaseStepDefinitions{
    private final HomePage homePage = new HomePage(driver);

    @Then("^Click on \"Empty\" area")
    public void myAccount(){
        homePage.ClickEmpty();
    }
}
