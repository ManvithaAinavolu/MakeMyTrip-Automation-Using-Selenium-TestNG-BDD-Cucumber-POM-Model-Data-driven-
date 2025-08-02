Feature: Validate MakeMyTrip Train Booking Flow

Scenario: User searches and filters trains and selects a preferred train

  Given To Launch the browser and enter url
  
  When Choose the From, To , Departure ,Select class for the Trains
  
  Then click on search button
  
  And Choose AC, Ticket Type, Quota for the trains
  
  Then Click on the preferred train
  
  And Take Screenshot and Close Browser
  