Feature: Create new project in pivotal tracker

  @deleteProject
  Scenario: Create new project
    Given I send a POST request to /projects with:
      | name   | projectTest |
      | public | true        |
    Then I expect status code 200
    And I expect that name be equals to projectTest