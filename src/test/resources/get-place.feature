@getPlace @regression
Feature: get place should perform
  Background: As an user I should be able see a place in google map
  Scenario: use should be able to see a place
    Given user has the place id
    When user sends "GET_PLACE" request with "GET" call
    Then user see the place