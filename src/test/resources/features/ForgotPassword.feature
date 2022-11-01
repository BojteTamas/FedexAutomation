@regression
Feature: Register account

  Background:
    Given I access Fedex home page
    And I close the popup
    And I accept all cookies

  Scenario: Check successfully forgot message
    When Click Sign Up Log In button
    And Click Log in button
    And Click FORGOT YOUR USER ID OR PASSWORD? button
    And Click RETRIEVE USER ID button
    Then Fill forgot password email address with emails11243@email.com
    Then Click SUBMIT button
    And The message: An email with your user ID(s) has been sent to emails11243@email.com. was displayed

  Scenario Outline: Test forgot password error messages
    When Click Sign Up Log In button
    And Click Log in button
    And Click FORGOT YOUR USER ID OR PASSWORD? button
    And Click RETRIEVE USER ID button
    Then Fill forgot password email address with <email>
    Then Click SUBMIT button
    And The message error message <errorMessage> was displayed
    Examples:
      | errorMessage                                | email |
      | Email address is required.                  | empty |
      | Email address is not in the correct format. | 1     |