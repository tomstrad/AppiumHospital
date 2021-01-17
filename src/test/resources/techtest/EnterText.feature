Feature: Entering Text into the Search Box


  Scenario: Entering Valid Text
    Given I see a search bar
    When I click on it
    Then I can enter text
    And I can clear the text
