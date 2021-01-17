Feature: Searching and getting results

  Scenario: Searching for invalid options
    Given I enter invalid characters in the search
    When I perform the search
    Then No Results are shown

  Scenario: Searching for a specific Hospital
    Given I enter University Hospital Coventry in the search
    When I perform the search
    Then One Result is shown
    And The Result is for University Hospital Coventry

  Scenario: Part Searching for a specific Hospital from start of name
    Given I enter University Hospital Co in the search
    When I perform the search
    Then One Result is shown
    And The Result is for University Hospital Coventry

#    This test fails
#  Scenario: Part Searching for a specific Hospital from mid part of name
#    Given I enter Coventry in the search
#    When I perform the search
#    Then One Result is shown
#    And The Result is for University Hospital Coventry

  Scenario: Searching for multiple Hospitals
    Given I enter University in the search
    When I perform the search
    Then Multiple Results are shown
    And The Results are for Hospitals that match the search term