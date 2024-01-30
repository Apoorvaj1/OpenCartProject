Feature: Login functionality for OpenCart Website

  As a user of the OpenCart website
  I want to be able to log in with my account and if in case if forgot password able to change
  So that I can access my account-related features and manage my orders

  Background:
    Given I am on the OpenCart login page

  @Sanity
  Scenario: Successful login with valid credentials
    Given I have entered valid username and password
    When I click on the login button
    Then I should be logged in successfully
  @Sanity
  Scenario: Successful login with valid credentials
    Given I have entered valid username and password
    When I click on the login button
    Then I should be logged in successfully

  @Regression
  Scenario: User forgotten login id password
    Given user can able to see forgot password link
    When user clicks Forgotten Password
    Then user able to see Email address field
    Then user able to enter email address