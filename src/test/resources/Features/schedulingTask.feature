Feature: Task scheduling

  #Add unit test
  #Add e2e test
  #Add integrate test
  #Add these snippets in PPT

    Background: Login the application
      Given User navigates to the application
      When User enters the username
      And User enters the password
      And Clicks on the login button

    @loginApplication
    Scenario: Login the application
      Then User navigates to the application dashboard

   @createAndScheduleTask
    Scenario: Create and schedule a task
      When User navigates to the application dashboard
      And User clicks on add button
      And User enters the title 'Automation scheduling task'
      And User clicks on create task button
      And User clicks on the no schedule option
      And User selects the start date '26'
      And user Selects the end date '30'
      And User clicks on close button
      And User clicks on record option
      And User clicks on quick records option
      And User clicks on open all task option
     Then User clicks on existing task 'Automation scheduling task'
      And Verify the scheduled date range is from '26' to '30'