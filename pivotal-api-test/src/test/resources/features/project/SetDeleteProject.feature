Feature: Update project settings

  Background: Create a project
    Given I send a POST request to /projects with:
      | name   | projectTest |
      | public | true        |
    And Store as Project1

  Scenario: Delete a project
    Given I send a DELETE request to /projects/[Project1.id]
    Then I expect status code 204

  @deleteProject
  Scenario: Edit a project
    Given I send a PUT request to /projects/[Project1.id] with:
      | name | nameSet |
    Then I expect status code 200
    And I expect that name be equals to nameSet

