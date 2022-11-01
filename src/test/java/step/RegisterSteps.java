
package step;

import static page.RegisterPage.LOGGED_IN_USER_NAME;

import helper.BaseStepUtilities;
import io.cucumber.java8.En;
import org.assertj.core.api.Assertions;
import page.RegisterPage;

public class RegisterSteps extends BaseStepUtilities implements En {

  public RegisterSteps() {
    Given(
        "Fill first name: {}",
        (String firstName) -> fillWebElement(RegisterPage.FIRST_NAME_INPUT, firstName));

    Given(
        "Fill last name: {}",
        (String lastName) -> fillWebElement(RegisterPage.LAST_NAME_INPUT, lastName));

    Given(
        "Fill address : {}",
        (String address) -> fillWebElement(RegisterPage.ADDRESS_INPUT, address));

    Given(
        "Fill phone number : {}",
        (String phoneNumber) -> fillWebElement(RegisterPage.PHONE_INPUT, phoneNumber));

    Given(
        "Fill email : {}",
        (String email) -> fillWebElement(RegisterPage.EMAIL_INPUT, email));

    And("Select first google result", () -> clickOnWebElement(RegisterPage.GOOGLE_FOUND_ADDRESSES));

    And("^Click Enter login details button$",
        () -> clickOnWebElement(RegisterPage.ENTER_LOGIN_DETAILS_BUTTON));

    And("Fill register password {}",
        (String password) -> fillWebElement(RegisterPage.PASSWORD_INPUT, password));

    And("Fill register confirm password {}",
        (String confirmPassword) -> fillWebElement(RegisterPage.CONFIRM_PASSWORD_INPUT,
            confirmPassword));

    And("^Click Terms of Use$", () -> {
      clickOnWebElement(RegisterPage.TERMS_AND_USE_LABEL);
    });

    And("^Click Create my User ID button$",
        () -> clickOnWebElement(RegisterPage.CREATE_MY_USER_ID_BUTTON));

    And("The login text with the username {} is displayed", (String username) -> {
      assertWithPoll(() -> Assertions.assertThat(getTextFromWebElement(LOGGED_IN_USER_NAME)).isEqualTo(username), 5);
    });
  }
}
