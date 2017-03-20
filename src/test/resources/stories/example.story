Scenario: Google's Search Functionality

Given I type query as '<keyword>'
When I submit
Then I should see title '<title>'

Examples:
|keyword|title|
|cat|cat - Google Search|