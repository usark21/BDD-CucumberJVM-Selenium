Feature: Menus available for Admin

To perform admin functions
As a legal firm administrator
I want to validate admin menu tab is available

@adminmenu
Scenario Outline: Validating admin menu tab availability
Given When Execute scenario is "<RunOrSkip>"
Given User logged in "Browser"
Then Admin tab on headermenu bar should be present
|	admin-menu	|
And I click on "<HeaderMenu>"
Then "<Verification_Object>" should be present

Examples:
|	HeaderMenu		|	Verification_Object		|	RunOrSkip	| 
| admin-menu	  |	admin-header	  		  |	RUN			  |
