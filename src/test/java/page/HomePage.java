package page;

import org.openqa.selenium.By;

public class HomePage {

  public static final By CLOSE_BUTTON = By.cssSelector("a[title='close']");
  public static final By ACCEPT_ALL_COOKIES_BUTTON = By.className("fxg-cookie-consent__apply");
  public static final By SIGN_IN_LOG_IN_BUTTON = By.id("global-login-wrapper");
  public static final By LOG_IN_BUTTON = By.cssSelector("a[title='Log In']");
  public static final String SOCIAL_MEDIA_BUTTONS = "//span[text()='Follow FedEx']/../following-sibling::div/a[contains(@href, '%s')]";

}
