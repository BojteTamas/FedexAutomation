package page;

import org.openqa.selenium.By;

public class LoginPage {

  public static final By OPEN_ACCOUNT_BUTTON = By.id("createUserId");
  public static final By LOGIN_BUTTON = By.id("login-btn");
  public static final By ERROR_MESSAGE = By.cssSelector("div.fdx-c-form-message--error");
  public static final By USER_ID_INPUT = By.id("userId");
  public static final By PASSWORD_INPUT = By.id("password");
  public static final By FORGOT_PASSWORD_BUTTON = By.id("requestCode-btn");


}
