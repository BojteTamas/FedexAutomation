
package step;

import static page.LoginPage.PASSWORD_INPUT;
import static page.LoginPage.USER_ID_INPUT;

import helper.BaseStepUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import page.LoginPage;

public class LoginSteps extends BaseStepUtilities {

  @And("Click NEW TO FEDEX? OPEN AN ACCOUNT button")
  public void clickNEWTOFEDEXOPENANACCOUNTButton() {
    clickOnWebElement(LoginPage.OPEN_ACCOUNT_BUTTON);
  }

  @And("Click LOG IN button")
  public void clickLOGINButton() {
    clickOnWebElement(LoginPage.LOGIN_BUTTON);
  }

  @And("Click FORGOT YOUR USER ID OR PASSWORD? button")
  public void clickFPBUTTON() {
    clickOnWebElement(LoginPage.FORGOT_PASSWORD_BUTTON);
  }

  @Then("The error {} was displayed")
  public void theErrorBothUserIDAndPasswordAreRequiredToLogInWasDisplayed(String error) {
    assertWithPoll(() -> Assertions.assertThat(getTextFromWebElement(LoginPage.ERROR_MESSAGE))
        .isEqualTo(error), 5);

  }

  @And("Fill user id with {}")
  public void fillUserIdWith(String text) {
    fillWebElement(USER_ID_INPUT, text);
  }

  @And("Fill password with {}")
  public void fillPasswordWith(String text) {
    fillWebElement(PASSWORD_INPUT, text);
  }
}
