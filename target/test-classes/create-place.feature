@happyPath @regression
Feature: user create a place in google map
  Background: as an user, i will be able to add a place in google map
    Scenario: user should be able add a place in google map
      Given user has the request body
      When user sends "CREATE_PLACE" request with "POST" call
      Then user see the place is added on the map