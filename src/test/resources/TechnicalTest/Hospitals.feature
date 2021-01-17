Feature: Accept GDPR


  Scenario: Accept GDPR on first opening
    Given I have launched the app
    When I am on the hospitals page
    Then I see a list of hospitals