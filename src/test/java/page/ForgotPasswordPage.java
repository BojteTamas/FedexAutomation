
package page;

import org.openqa.selenium.By;

public class ForgotPasswordPage {

  public static final By RETRIEVE_USER_ID_BUTTON = By.id("retrieve-btn");
  public static final By SUBMIT_BUTTON = By.id("submit-btn");
  public static final By EMAIL_ADDRESS_INPUT = By.id("email");
  public static final By SUCCESS_MESSAGE = By.id("email-sent-msg");
  public static final By ERROR_MESSAGE = By.cssSelector("form div[role='alert']");
}
