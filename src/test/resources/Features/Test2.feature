@test
Feature: Acceptance test

  Background:
    * User navigated to ToDo application

  Scenario Outline: I should be able mark item as UNDONE
    Given ToDo list with marked "<item>" item
    When I click on "checkBox" next to "<item>" item
    Then I should see "<item>" item marked as UNDONE
    Examples:
  | item          |
  | buy some milk |

  Scenario Outline: I should be able to clear ToDo list
    Given ToDo list with "<item>" item
    When I click on "deleteButton" next to "<item>" item
    Then List should be empty
    Examples:
  | item             |
  | rest for a while |

  Scenario Outline: I should be able to delete one item
    Given ToDo list with "<item1>" and "<item2>" item in order
    When I click on "deleteButton" next to "<item1>" item
    Then I should see "<item2>" item in ToDo list
    Examples:
  | item1            | item2       |
  | rest for a while | drink water |

  Scenario: I should be able to add FAILED TEST to empty ToDo list
    Given Empty ToDo list
    When I write "test1" to TextBox and press enter
    Then I should see "test1" item in ToDo list