
package step;

import static page.ForgotPasswordPage.EMAIL_ADDRESS_INPUT;
import static page.ForgotPasswordPage.ERROR_MESSAGE;
import static page.ForgotPasswordPage.SUCCESS_MESSAGE;
import static page.RegisterPage.LOGGED_IN_USER_NAME;

import helper.BaseStepUtilities;
import io.cucumber.java.en.And;
import org.assertj.core.api.Assertions;
import page.ForgotPasswordPage;

public class ForgotPasswordSteps extends BaseStepUtilities {

  @And("Click RETRIEVE USER ID button")
  public void clickOPENANACCOUNTButton() {
    clickOnWebElement(ForgotPasswordPage.RETRIEVE_USER_ID_BUTTON);
  }

  @And("Click SUBMIT button")
  public void clickSButton() {
    clickOnWebElement(ForgotPasswordPage.SUBMIT_BUTTON);
  }

  @And("Fill forgot password email address with {}")
  public void fillUserIdWith(String text) {
    if (text.equals("empty")) {
      fillWebElement(EMAIL_ADDRESS_INPUT, "");
    }else {
      fillWebElement(EMAIL_ADDRESS_INPUT, text);

    }
  }

  @And("The message: {} was displayed")
  public void theMessageAnEmailWithYourUserIDSHasBeenSentToEmailsEmailComWasDisplayed(String email) {
    assertWithPoll(() -> Assertions.assertThat(getTextFromWebElement(SUCCESS_MESSAGE)).isEqualTo(email), 5);

  }

  @And("The message error message {} was displayed")
  public void theMessageErrorMessageEmailAddressIsRequiredWasDisplayed(String errorMessage) {
    assertWithPoll(() -> Assertions.assertThat(getTextFromWebElement(ERROR_MESSAGE)).isEqualTo(errorMessage), 5);

  }
}

