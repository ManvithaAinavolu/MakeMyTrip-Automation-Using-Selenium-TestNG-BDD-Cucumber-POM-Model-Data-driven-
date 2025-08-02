
Feature: To validate the MakeMyTrip functionality

Background:
    Given Launch the browser and navigate to URL
    And close the Browser
    

Scenario: To validate the search functionality


When Choose the From, To , Departure ,Select class for the Trains

Then click on search button




 
@smoke
Scenario: To validate Filter functionality

Given To search for trains in General Quota

When Choose AC, Ticket Type, Quota for the trains

Then Click on the preferred train





@searchCities
Scenario Outline: To search for Trains between different places


When choose "<from>", "<to>", "<travelMonth>", "<travelDay>", "<Class>" for Trains

Then click on search



Examples:

|from 			 | to         | travelMonth |travelDay | Class       |
| Hyderabad  | Delhi      | July 2025 | 20 |All Class            |
| Mumbai     | Bangalore  | July 2025 | 29 |Sleeper Class        |
| Chennai    | Kolkata    | August 2025 | 30   |All Class        |


@totalBooking
Scenario: To Book a Train Ticket

Given To search for trains in General Quota

When Choose AC, Ticket Type, Quota for the trains

Then Click on the preferred train

And Take Screenshot 

Given enter travveler details using IRCTC Username

When Click on Add Trveller to enter the traveller details and enter the valid IRCTC Username

Then Give Contact email , mobile number and click on consent

And Click on Pay and Book Ticket, Close the Browser

#Data Table

@dataTable
Scenario: To Book a Train Ticket from different places
When Enter "<from>", "<to>", "<travelMonth>", "<travelDay>", "<Class>" for Trains

|from 			 | to         | travelMonth |travelDay | Class       |
| Hyderabad  | Delhi      | July 2025 | 20 |All Class            |
| Mumbai     | Bangalore  | July 2025 | 29 |Sleeper Class        |
| Chennai    | Kolkata    | August 2025 | 30   |All Class        |


When Select AC, Ticket Type, Quota for the trains

Then choose on the preferred train

And Take a Screenshot 



	