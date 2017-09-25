Feature: Check agenda events adding
  As TestWarez conference participant
  I should be able to see chosen by me events in my schedule

  Scenario: Events Favorites Adding via TestWarez App

    Given I am on agenda start view

    When I add first event to favorites

    And I select MY SCHEDULE

    Then I see an event I added in MY SCHEDULE