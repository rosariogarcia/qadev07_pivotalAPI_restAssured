Feature: Create new story in project from pivotal tracker

  Background: Create Project
    Given I send a POST request to /projects with:
      | name   | projectTest |
      | public | true        |
    Then I expect status code 200
    And Store as Project1

  @story
  Scenario: Create new story
    Given I send a POST request to /projects/[Project1.id]/stories with:
      | name     | newStory |
      | estimate | 1        |
    Then I expect status code 200
    And I expect that name be equals to newStory