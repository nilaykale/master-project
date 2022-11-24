package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.LoginPage;

public class LoginStepDefinitions extends BaseStepDefinitions{
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("^User navigates to login page$")
    public void launchBrowser() {super.launchBrowser();}

    @Then("^User enters (.*) and (.*)$")
    public void enter_Username_Password(String email, String password){
        loginPage.enter_Username_Password(email, password);
    }

    @Then("^Click on \"Accepted\" button$")
    public void accepted(){
        loginPage.accepted();
    }


    @Then("^Click on \"Sign In\" button$")
    public void login(){
        loginPage.login();
    }

    @Then("^User should see the error message and close it$")
    public void CloseErrorMessage(){
        loginPage.CloseErrorMessage();
    }

    @Then("^User should see the Password True$")
    public void PasswordTrue(){
        loginPage.PasswordTrue();
    }

    @Then("^User should see the EmailError Messages$")
    public void CheckEmailErrorMessage(){
        loginPage.CheckEmailErrorMessage();
    }

    @Then("^User should see the PasswordError Messages$")
    public void CheckPasswordErrorMessage(){
        loginPage.CheckPasswordErrorMessage();
    }

    @Then("^Click on \"MyAccount\" button$")
    public void MyAccount(){
        loginPage.MyAccount();
    }
}
