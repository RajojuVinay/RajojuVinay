Feature: Send Work Offer Feature

  Background:
    Given navigate to the website

    And login with <"berlin@mailinator.com"> and <"Qwerty@123">
    
    And redirect to public profile <{url}>

  Scenario: Send Work Offer with 3 months contract
    And Select contract Duration of <"3"> months
    And Select working hours days as <"4">
    And Select working days per week as <"5">
    Then Agree with Terms and Conditons
    Then Send work offer

  Scenario: