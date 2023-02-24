@customPlace @regression
Feature: Validation Place API

  Background: user should be able to add a custom place on google map

  Scenario Outline: Verify google api should be created wit status 200 - success
    Given the request body should be a google schema with "<address>" "<language>" "<name>" fields
    When user sends "CREATE_PLACE" request with "POST" call
    Then  user see the place is added on the map
    And the "status" in response body should be "OK"
    And the "scope" in response body should be "APP"
    Examples:
      | address                    | language | name           |
      | 6302 34th Ave Woodside, NY | US_EN    | Student House  |
      | Bashundara RA, Dhaka-1210  | IN_EN    | The dream home |
