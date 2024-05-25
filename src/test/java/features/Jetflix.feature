Feature: Jetflix Mobile App Testing

  Scenario: Verify Movie Title Consistency
    Given I am on the Jetflix home page
    When I open the filter menu
    And I select the release date filter then close the menu
    Then I search for the movie "(.*?)"

  Scenario: Verify Future Release Dates Filter
    Given I am on the Jetflix home page
    When I open the filter menu
    And I select the release date filter then close the menu
    Then all movies should have future release dates