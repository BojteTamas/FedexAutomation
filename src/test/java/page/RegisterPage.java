
package page;

import org.openqa.selenium.By;

public class RegisterPage {

  public static final By FIRST_NAME_INPUT = By.id("first-name");
  public static final By LAST_NAME_INPUT = By.id("last-name");
  public static final By ADDRESS_INPUT = By.id("address");
  public static final By PHONE_INPUT = By.id("phone");
  public static final By EMAIL_INPUT = By.id("email");
  public static final By ENTER_LOGIN_DETAILS_BUTTON = By.cssSelector("button[data-test-id='contactFormSubmitButton']");
  public static final By PASSWORD_INPUT = By.id("password");
  public static final By CONFIRM_PASSWORD_INPUT = By.id("confirmPassword");
  public static final By TERMS_AND_USE_LABEL = By.id("PP_AND_TAC-label");
  public static final By CREATE_MY_USER_ID_BUTTON = By.cssSelector("button[data-test-id='signupFormSubmitButton']");
  public static final By GOOGLE_FOUND_ADDRESSES = By.cssSelector("div.pac-item");
  public static final By LOGGED_IN_USER_NAME = By.id("fdx-sjson-signInText");
}
