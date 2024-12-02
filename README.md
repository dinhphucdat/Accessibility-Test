# Accessibility-Test
# H1 Introduction

In order to evaluate systems or tools, it is extremely common to create a test suite that can be
used to evaluate a single system or compare multiple systems. For this assignment, we will be
looking at the results of multiple tools that were run on a test suite created by the United
Kingdom’s Government Digital Services to test accessibility checkers. An accessible page is one
that is usable by people with disabilities, many of whom will be accessing the web with assistive
technologies such as screen readers or dictation software. The test suite has a series of tests,
each with a single introduced error. The tests are grouped within categories of related tests.
These tests have been run on 13 different accessibility checkers and the full results have been
made publicly available. For this assignment, you will work with the content of the file,
a11yCheckersResults.txt that contains the results of the tests for 4 of the 13 checkers. The file
is organized such that each line contains the results for one test organized as such:
[category] [google result] [wave result] [sortsite result] [aslint result] [test description]

The category and test results for each checker are all a single “word”. The test description is of
variable length.
The test results will be one of six “words”:
• error = the issue was properly found
• error_paid = the issue was properly found in the paid version
• warning = the tool only gave a warning
• manual = the tool required the user to check
• identified = The tool noticed the issue, but didn’t give a warning
• notfound = The tool did not identify the issue
This assignment will have you write code to read in the test results list and then use them to
display different information about the tests.
# H1 Part 1: AccessibilityTest

You are to design and implement a class named AccessibilityTest, which stores the category
and description of the test and the results of the test for the four checkers. The constructor for
the class should take all 6 pieces of information as parameters and store those values in fields.
It should have accessor methods for each value, e.g., getCategory, getDescription,
getGoogleResult, etc. It should also have the toString method which presents a readable
format of the results of the test.
# H1 Part 2: AccessibilityResults

The file a11yCheckersResults.txt as been provided for you, which contains the information
about tests used by the UK Government Digital Services to evaluate accessibility checkers. Each
line in the file contains the information about a single test organized as:
[category] [google result] [wave result] [sortsite result] [aslint result]
[test description]
For instance, the line for the test that is used to see if a person can visually determine which
element has keyboard focus looks like this:
Keyboard notfound notfound error error Keyboard focus is not indicated
visually
This line indicates that the test is in the Keyboard category of tests, the error was not detected
by the Google or WAVE result but was detected by SortSite and ASLint