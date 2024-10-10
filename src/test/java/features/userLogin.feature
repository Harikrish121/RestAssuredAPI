@regression
Feature: this feature is to test the validation of an existing user

@existingUserLogin
  Scenario: logging an existing user to our ecommerce website
    Given user logsIn with username as "benzmarksaviouro@gmail.com" and userpassword as "Stuartcent@123"
    And user hits the request as "LoginUserApi" with "post" httprequest
    Then after that user should get the status code of 200
