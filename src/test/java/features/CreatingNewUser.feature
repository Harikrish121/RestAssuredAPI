@regression
Feature: This feature file is used to test the validation
         of creating new user in this ecommerce website

  @newUserLogin
  Scenario Outline: verify that a new users are created after hitting the endpoints
    Given add user payload with "<fname>" "<lname>" "<userEmail>"  "<userPassword>" "<confirmPassword>" "<mobileNumber>"
    When user calls "CreateNewUserApi" with "post" httprequest
    Then the api call is success with the statuscode 200
    Then the response should be message and should equals to "Registered Successfully"

    Examples: 
      | fname   | lname       | userEmail                   | userPassword   | confirmPassword | mobileNumber |
      | mark    | hdhsaviour  | benzaskjsaaviouro@gmail.com | Stuartcent@123 | Stuartcent@123  |   5564646646 |
      | rufallo | adkhsaviour | llosadkahkdviour@gmail.com  | Markbenz@123   | Markbenz@123    |   5564646647 |
