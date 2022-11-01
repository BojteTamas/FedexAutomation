
package step;

import helper.BaseStepUtilities;
import io.cucumber.java.en.And;
import page.LoginPage;
import page.OpenAccountPage;

public class OpenAccountSteps extends BaseStepUtilities {

  @And("Click OPEN AN ACCOUNT button")
  public void clickOPENANACCOUNTButton() {
    clickOnWebElement(OpenAccountPage.OPEN_ACCOUNT_BUTTON);

  }
}

