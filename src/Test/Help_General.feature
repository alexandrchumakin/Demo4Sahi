@feature_Help_General
Feature: Help_General

  @positive @dev
  Scenario: (__1) Help link on Login page is active
    Given I am on login page for the "Camstar" tenant
    When I click on link "Help"
    And I switch to popup window "Online Help"
    Then I should see text on page containing "Accessing Omneo"