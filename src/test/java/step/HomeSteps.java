package step;

import static page.HomePage.ACCEPT_ALL_COOKIES_BUTTON;
import static page.HomePage.LOG_IN_BUTTON;
import static page.HomePage.SIGN_IN_LOG_IN_BUTTON;
import static step.BaseSteps.getDriver;

import helper.BaseStepUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import page.HomePage;

public class HomeSteps extends BaseStepUtilities {


  @Given("I access Fedex home page")
  public void iNavigateFedExHome() {
    getDriver().navigate().to("https://www.fedex.com/en-gb/home.html");
  }

  @When("Click on {}")
  public void clickOnButton(String button) {
    clickOnWebElement(By.xpath(String.format(HomePage.SOCIAL_MEDIA_BUTTONS, button)));

  }

  @And("I close the popup")
  public void iCloseThePopup() {
    clickOnWebElement(HomePage.CLOSE_BUTTON);
  }

  @And("I accept all cookies")
  public void iAcceptAllCookies() {
    clickOnWebElement(ACCEPT_ALL_COOKIES_BUTTON);
  }

  @Then("The expected link {} is displayed")
  public void theLinkIsDisplayed(String expectedLink) {
    assertCurrentUrl(expectedLink);
  }

  @When("Click Sign Up Log In button")
  public void clickSignUpLogInButton() {
    clickOnWebElement(SIGN_IN_LOG_IN_BUTTON);
  }

  @And("Click Log in button")
  public void clickLogInButton() {
    clickOnWebElement(LOG_IN_BUTTON);
  }
}
