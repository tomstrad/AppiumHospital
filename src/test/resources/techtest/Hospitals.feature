Feature: List of Hospitals


  Scenario: Opening App
    Given I have launched the app
    When I am on the hospitals page
    Then I see a list of hospitals
    And I see the hospitals type
    And I see a search bar
    And I click on it