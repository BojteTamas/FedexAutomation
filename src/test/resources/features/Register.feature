@regression
Feature: Register account

  Background:
    Given I access Fedex home page
    And I close the popup
    And I accept all cookies

  Scenario: Test success register
    When Click Sign Up Log In button
    And Click Log in button
    And Click NEW TO FEDEX? OPEN AN ACCOUNT button
    And Click OPEN AN ACCOUNT button
    Then Fill first name: FIRST3
    Then Fill last name: LAST3
    And Fill address : Bond Gate, Nuneaton CV11 4AL
    And Select first google result
    And Fill phone number : 24 7663 7637
    And Fill email : emails11243@email.com
    And Click Enter login details button
    And Fill register password hdashkjdshjkkhjdsahjkr3782478J
    And Fill register confirm password hdashkjdshjkkhjdsahjkr3782478J
    And Click Terms of Use
    And Click Create my User ID button
    And The login text with the username FIRST3 is displayed
