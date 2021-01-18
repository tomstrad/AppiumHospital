Feature: Click on the search Result


  Scenario: Search result info
    Given I enter University Hospital Coventry in the search
    When I click on the first result
    Then I am taken to the results page
    And I can return to the search page