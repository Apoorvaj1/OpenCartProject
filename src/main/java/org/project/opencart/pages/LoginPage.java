package org.project.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    //Locators
    private By EmailaddressLoginId = By.xpath("//input[@name=\"email\"]");
    private By PasswordforLogin = By.xpath("//input[@name=\"password\"]");
    private By LoginButton = By.xpath("//input[@type=\"submit\"]");
    private By Forgotten_Password_Link = By.linkText("Forgotten Password");
    private By logoutLinkLocator = By.linkText("Logout");


    //Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //Methods
    public void enterEmail(String email) throws InterruptedException {
        WebElement emailInput = driver.findElement(EmailaddressLoginId);
        emailInput.sendKeys(email);
        Thread.sleep(2000);
    }
    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(PasswordforLogin);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(LoginButton);
        loginButton.click();
    }

    public void clickForgottenPasswordLink() {
        WebElement forgottenPasswordLink = driver.findElement(Forgotten_Password_Link);
        forgottenPasswordLink.click();
    }

    public boolean checkForgotPwdLink(){
        return driver.findElement(Forgotten_Password_Link).isDisplayed();
    }

    public boolean checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }

    public void login(String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageUrl(){
        String forgotPwdPageUrl = driver.getCurrentUrl();
        return forgotPwdPageUrl;
    }

}
