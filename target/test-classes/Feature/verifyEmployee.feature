Feature: Verify Employee API

  #Author:Aniket
  @Get
  Scenario Outline: Get an employees details
    Given User give the base uri "<baseuri>"
    When user give the endpoint "<endpoint>"
    Then Get the information according to the endpoint
    Examples:
    |baseuri|endpoint|
    |https://dummy.restapiexample.com|/api/v1/employees|
    |https://dummy.restapiexample.com|/api/v1/employee/2150|
    
  @Post
  Scenario Outline: Post an employee data
    Given User will give the base uri "https://dummy.restapiexample.com" and endpoint "/api/v1/create"
    When User will give the file "Post.txt"
    Then Post the employee data
    
  @Put
  Scenario Outline: Put some changes in an employee data
    Given User will provide the id "8439" and the updated file "Put.txt"
    Then Update the employee details according to the id
   
  @Patch
  Scenario Outline: Doing changes to some particular id
    Given The user will provide the id "8439"
    When User will provide the file "Patch.txt"
    Then Do the partial changes in the particular id
   
  @Delete
  Scenario: Delete a particular employee details
    Given User will give the ep "/api/v1/delete/2" which has to be deleted 
    Then Delete the details