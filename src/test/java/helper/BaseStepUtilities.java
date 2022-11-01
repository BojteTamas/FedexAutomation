package helper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.awaitility.pollinterval.FibonacciPollInterval.fibonacci;
import static org.junit.Assert.fail;
import static step.BaseSteps.getDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.awaitility.core.ConditionTimeoutException;
import org.awaitility.core.ThrowingRunnable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

@Slf4j
public class BaseStepUtilities {


  public void waitForPageLoaded() {
    try {
      assertWithPoll(
          () ->
              assertThat(
                  getDriver()
                      .executeScript("return document.readyState")
                      .toString()
                      .contentEquals("complete"))
                  .isTrue(), 5);
    } catch (Throwable ignored) {

    }
  }

  public void waitUntilIdentifiedElementIsVisibleAndClickable(final Object selector, int seconds) {
    waitForPageLoaded();
    await()
        .catchUncaughtExceptions()
        .ignoreExceptions()
        .timeout(Duration.ofSeconds(5))
        .untilAsserted(() -> {
          assertThat(getDriver().findElements(By.id("loader"))).isEmpty();
        });
    if (selector instanceof By) {
      assertWithPoll(
          () -> {
            scrollToElement(selector);
            assertThat(getDriver().findElement((By) selector).isEnabled()).isTrue();
            assertThat(getDriver().findElement((By) selector).isDisplayed()).isTrue();
          },
          seconds);
    } else if (selector instanceof WebElement) {
      assertWithPoll(
          () -> {
            scrollToElement(selector);
            assertThat(((WebElement) selector).isEnabled()).isTrue();
            assertThat(((WebElement) selector).isDisplayed()).isTrue();
          }, seconds);
    } else {
      throw new NotFoundException("This type is not available");
    }
  }

  public void scrollToElement(final Object selector) {
    try {
      waitForPageLoaded();
      JavascriptExecutor javascriptExecutor = getDriver();
      if (selector instanceof WebElement) {
        javascriptExecutor.executeScript(
            "arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"center\"});",
            selector);
      } else {
        javascriptExecutor.executeScript(
            "arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"center\"});",
            getDriver().findElement((By) selector));
      }
    } catch (Throwable ignored) {
    }
  }

  public void clickOnWebElement(By selector) {
    waitUntilIdentifiedElementIsVisibleAndClickable(selector, 10);
    getDriver().findElement(selector).click();
  }

  public String getTextFromWebElement(By selector) {
    waitUntilIdentifiedElementIsVisibleAndClickable(selector, 10);
   return getDriver().findElement(selector).getText();
  }

  public void fillWebElement(By selector, String text) {
    waitUntilIdentifiedElementIsVisibleAndClickable(selector, 10);
    getDriver().findElement(selector).sendKeys(text);
  }

  public void assertCurrentUrl(String expectedLink) {
    assertWithPoll(() -> assertThat(getDriver().getCurrentUrl()).isEqualTo(expectedLink), 5);
  }

  @SneakyThrows
  public static void assertWithPoll(ThrowingRunnable throwingRunnable, int seconds) {
    try {
      await()
          .pollInterval(fibonacci(TimeUnit.MILLISECONDS))
          .ignoreExceptions()
          .catchUncaughtExceptions()
          .timeout(Duration.ofSeconds(seconds))
          .untilAsserted(throwingRunnable);
    } catch (ConditionTimeoutException e) {
      log.error(e.getMessage());
      log.error(Arrays.toString(e.getStackTrace()));
      fail(e.getCause().getLocalizedMessage());
    }
  }

}
