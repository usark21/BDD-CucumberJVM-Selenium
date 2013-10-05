Feature: Logging into Contract Management

To work in law firm
As a legal assistant
I have to login to Contract Management web application

@login
Scenario Outline: Logging in Contract Management
Given When Execute scenario is "<RunOrSkip>"
Given I open "<Browser>" and type "appurl" 
And I enter "<Username>" for "userid" input 
And I enter "<Password>" for "password" input
And I click on "login"
Then I should be "<Expected_Result>" to login

Examples:
|	  Browser		|	Username	|	Password	|	Expected_Result	|	RunOrSkip	|   
| 	Mozilla		|	URAVIKUM	|	support	  |	failed			    |	SKIP  		|
| 	Mozilla		|	URAVIKUM	|	supp0rt	  |	successfull		  |	RUN		  	|
