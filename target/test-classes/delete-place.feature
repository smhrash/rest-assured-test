@deletePlace @regression
Feature: delete place should perform
  Background: As an user I should be able delete a place in google map
    Scenario: place should be deleted
      Given user has the place id
      When user sends "DELETE_PLACE" request with "DELETE" call
      Then user see place has been deleted