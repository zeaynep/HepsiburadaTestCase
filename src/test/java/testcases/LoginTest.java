package testcases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.CommonMethods;
import utility.OpenWebsite;
import utility.Variables;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginTest {
    public static WebDriver driver;
    Variables variables = new Variables();
    CommonMethods commonMethods;

    private By loginButtonId = By.id(variables.loginButtonId);
    private By loginLinkId = By.id(variables.loginLinkId);
    private By myAccountXPathSelector = By.xpath(variables.myAccountXPath);
    private By btnLoginId = By.id(variables.btnLoginId);
    private By txtUserName = By.id(variables.txtUserName);
    private By txtPassword = By.id(variables.txtPassword);


    @Given("I have opened {string}")
    public void iGoingToTheLoginPage(String baseUrl) {
        OpenWebsite ow = new OpenWebsite(baseUrl);
        driver = ow.getDriver();
        commonMethods = ow.getCommonMethods();
    }

    @When("I fill the username field with {string}, {string}")
    public void fillTheUsername(String email, String userPassword) throws InterruptedException {
        commonMethods.writeText(txtUserName, email);
        Thread.sleep(1000);
        if(!driver.findElements(txtPassword).isEmpty()){
            commonMethods.clickWithFindElement(btnLoginId);
        }
        commonMethods.writeText(txtPassword, userPassword);
        if(!driver.findElements(btnLoginId).isEmpty()){
            commonMethods.clickWithFindElement(btnLoginId);
        }else{
            commonMethods.clickWithFindElement(btnLoginId);
        }

    }

    @Then("I have seen the home page")
    public void seeHomePage() {
        String myAccountText = driver.findElement(myAccountXPathSelector).getText();
        Assert.assertNotEquals(myAccountText, "Giriş Yap");
    }

}