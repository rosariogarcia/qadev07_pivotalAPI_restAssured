Feature: Delete story

  Background: Create a project
    Given I send a POST request to /projects with:
      | name   | projectTest |
      | public | true        |
    And Store as Project1

    And I send a POST request to /projects/[Project1.id]/stories with:
      | name     | newStory |
      | estimate | 1        |
    And Store as Storie1

  Scenario: Delete a story
    Given I send a DELETE request to /projects/[Storie1.project_id]/stories/[Storie1.id]
    Then I expect status code 204