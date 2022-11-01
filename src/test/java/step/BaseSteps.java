package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseSteps {

  public static RemoteWebDriver getDriver() {
    return driver;
  }

  private static RemoteWebDriver driver;

  @Before
  public void before() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
//    options.setHeadless(true);
    driver = new ChromeDriver(options);
    driver.manage().window().setSize(new Dimension(1800, 1000));

  }

  @After
  public void after(Scenario scenario) {
    if (scenario.isFailed()) {
      scenario.log("Scenario failed so capturing a screenshot");

      TakesScreenshot screenshot = (TakesScreenshot) driver;
      scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png",
          scenario.getName());
    }
    if (driver != null) {
      driver.quit();
    }
  }

}
