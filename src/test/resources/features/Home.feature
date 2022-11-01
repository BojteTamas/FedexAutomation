@regression
Feature: Home page tests

  Background:
    Given I access Fedex home page
    And I close the popup
    And I accept all cookies

  Scenario Outline: Ensure that Social Media buttons work
    When Click on <button>
    Then The expected link <link> is displayed

    Examples:
      | button   | link                                   |
      | facebook | https://www.facebook.com/FedExEurope   |
      | twitter  | https://twitter.com/FedExEurope        |
      | youtube  | https://www.youtube.com/user/FedEx     |
      | linkedin | https://www.linkedin.com/company/fedex |