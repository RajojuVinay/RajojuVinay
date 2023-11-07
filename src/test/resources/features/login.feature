
Feature: Login functionality

  Background:
    Given navigate to the website
  @smoke
  Scenario: correct username wrong password
    And enter your username<"vinaypartnerm13@mailinator.com">
    And enter the password<"Qwerty@12">
    And click login button
    Then verify inline error message
    Then verify the error message
  @smoke
  Scenario: Wrong username right password
    And enter your username<"far1@gmail.com">
    And enter the password<"Qwerty@123">
    And click login button
    Then verify inline error message
    Then verify the error message

  @smoke
  Scenario: What if username is not passed in?
    And enter your username<"">
    And enter the password<"Password1234">
    And click login button
    Then verify inline error message
    Then verify the error message
  @smoke
  Scenario: What if password is not passed in?
    And enter your username<"pekepex123@aosod.com">
    And enter the password<"">
    And click login button
    Then verify inline error message
    Then verify the error message
  @smoke
  Scenario: For valid username and password
    And enter your username<"vinaypartnerm13@mailinator.com">
    And enter the password<"Qwerty@123">
    And click login button
    #Then verify the user has logged in successfully
