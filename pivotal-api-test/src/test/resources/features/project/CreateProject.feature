Feature: Create new project in pivotal tracker

  @project
  Scenario: Create new project
    Given I send a POST request to /projects with:
      | name   | project |
      | public | true    |
    Then I expect status code 200
    And I expect that name be equals to project