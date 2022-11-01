@regression
Feature: Login tests

  Background:
    Given I access Fedex home page
    And I close the popup
    And I accept all cookies

  Scenario: Test empty fields error
    When Click Sign Up Log In button
    And Click Log in button
    And Click LOG IN button
    Then The error Both user ID and password are required to log in. was displayed

  Scenario: Test wrong user name and password
    When Click Sign Up Log In button
    And Click Log in button
    And Fill user id with 1
    And Fill password with 1
    And Click LOG IN button
    Then The error Login incorrect. Either the user ID or password combination is incorrect, or the account has been locked. Please try again or reset your password. was displayed