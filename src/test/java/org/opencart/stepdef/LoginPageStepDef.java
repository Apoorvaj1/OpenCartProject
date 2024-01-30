package org.opencart.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.project.opencart.pages.LoginPage;
import org.testng.Assert;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }


    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        driver.manage().window().maximize();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }
    @Given("I have entered valid username and password")
    public void i_have_entered_valid_username_and_password() throws InterruptedException {
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {
        loginPage.clickLoginButton();
        Thread.sleep(2000);
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(), true);
        System.out.println("Verified -> Logout link is available");
    }

    @Given("user can able to see forgot password link")
    public void user_can_able_to_see_forgot_password_link() throws InterruptedException {
        Assert.assertEquals(loginPage.checkForgotPwdLink(), true);
        System.out.println("Verified -> Forgotten Password link is available");

    }

    @When("user clicks Forgotten Password")
    public void user_clicks_forgotten_password() throws InterruptedException {
        loginPage.clickForgottenPasswordLink();
        Thread.sleep(2000);
    }

    @Then("user able to see Email address field")
    public void user_able_to_see_email_address_field() throws InterruptedException {

        Assert.assertEquals(loginPage.verifyForgotPasswordEmail(),true);
        System.out.println("Email address -> Verified");
        Thread.sleep(2000);
    }

    @Then("user able to enter email address")
    public void user_able_to_enter_email_address() throws InterruptedException {
        loginPage.ForgottenPasswordEmail("Apoorv123@gmail.com");
        Thread.sleep(2000);
    }

}
