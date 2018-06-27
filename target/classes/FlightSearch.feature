@ClearTripTest @FlightSearch
Feature: Cleartrip Flight Search

  @OneWay_FlightSearchTest
  Scenario: Verify flight search on clear trip site.
    When verify user is on home page
    Then User has to select the trip type as "oneway"
    Then User has to enter in "from" textbox
    Then User has to enter in "to" textbox
    Then User has to enter "fromDate" textbox
    And User will select number of passenger from "adult" dropdown
    And User choose to click on search flight button
    And Verify that user is lands on search result page

  @RoundTrip_FlightSearchTest
  Scenario: Verify flight search on clear trip site.
    When verify user is on home page
    Then User has to select the trip type as "roundtrip"
    Then User has to enter in "from" textbox
    Then User has to enter in "to" textbox
    Then User has to enter "fromDate" textbox
    Then User has to enter "toDate" textbox
    And User will select number of passenger from "adult" dropdown
    And User choose to click on search flight button
    And Verify that user is lands on search result page

  @MultiRound_FlightSearchTest
  Scenario: Verify flight search on clear trip site.
    When verify user is on home page
    Then User has to select the trip type as "multicity"
    Then User has to enter in "from" textbox
    Then User has to enter in "to" textbox
    Then User has to enter "fromDate" textbox
    And User will select number of passenger from "adult" dropdown
    And User choose to click on search flight button
    And Verify that user is lands on search result page
