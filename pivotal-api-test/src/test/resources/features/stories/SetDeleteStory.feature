Feature: Update a story in project from pivotal tracker

  Background: Create Project
    Given I send a POST request to /projects with:
      | name   | projectTest |
      | public | true        |
    And Store as Project1

    Given I send a POST request to /projects/[Project1.id]/stories with:
      | name     | newStory |
      | estimate | 1        |
    And Store as Storie1



  @deleteProjectStory
  Scenario: Edit a story
    Given I send a PUT request to /projects/[Storie1.project_id]/stories/[Storie1.id] with:
      | name | nameStorySet |
    Then I expect status code 200
    And I expect that name be equals to nameStorySet

  Scenario: Delete a story
    Given I send a DELETE request to /projects/[Storie1.project_id]/stories/[Storie1.id]
    Then I expect status code 204