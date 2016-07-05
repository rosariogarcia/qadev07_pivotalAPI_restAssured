Feature: Delete project

  Background: Create a project
    Given I send a POST request to /projects with:
      | name   | projectTest |
      | public | true         |
    And Store as Project1

  Scenario: Delete a project
    Given I send a DELETE request to /projects/[Project1.id]
    Then I expect status code 204