Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: MidnightWithEvenSeconds
When the time is 00:00:10
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: MidnightWithOddSeconds
When the time is 00:00:11
Then the clock should look like
O
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: 4 hours past midnight
When the time is 04:00:00
Then the clock should look like
Y
OOOO
RRRR
OOOOOOOOOOO
OOOO

Scenario: 5 hours past midnight
When the time is 05:00:00
Then the clock should look like
Y
ROOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: 6 hours past midnight
When the time is 06:00:00
Then the clock should look like
Y
ROOO
ROOO
OOOOOOOOOOO
OOOO

Scenario: 10 hours past midnight
When the time is 10:00:00
Then the clock should look like
Y
RROO
OOOO
OOOOOOOOOOO
OOOO

Scenario: 11 hours past midnight
When the time is 11:00:00
Then the clock should look like
Y
RROO
ROOO
OOOOOOOOOOO
OOOO

Scenario: 4 minutes past midnight
When the time is 00:04:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
YYYY

Scenario: 5 minutes past midnight
When the time is 00:05:00
Then the clock should look like
Y
OOOO
OOOO
YOOOOOOOOOO
OOOO

Scenario: 9 minutes past midnight
When the time is 00:09:00
Then the clock should look like
Y
OOOO
OOOO
YOOOOOOOOOO
YYYY

Scenario: 13 minutes past midnight
When the time is 00:13:00
Then the clock should look like
Y
OOOO
OOOO
YYOOOOOOOOO
YYYO

Scenario: 15 minutes past midnight
When the time is 00:15:00
Then the clock should look like
Y
OOOO
OOOO
YYROOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO



