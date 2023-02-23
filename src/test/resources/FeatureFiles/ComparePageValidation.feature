Feature: This is to Validate Teams Module

@first
Scenario: This scenario is to Check Teams List
Given user passing headers "Content-Type" as a "application/json" 
And user passing headers "X-RapidAPI-Key" and "X-RapidAPI-Host" values as below
|X-RapidAPI-Key|X-RapidAPI-Host|
|0772a54589mshb80c4a5a30206e5p1d4673jsn56c25e396c68|cricbuzz-cricket.p.rapidapi.com|
When user process "GET" method
Then verify that Status code  should be "200" and response should have "teamName"
|teamName|
|India|