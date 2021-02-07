@test
Feature: Acceptance test3

  Background:
    * User navigated to ToDo application

  @1 @2
  Scenario Outline: I should see "<secondItem>" item below "<firstItem>"
    Given ToDo list with "<firstItem>" item
    When I write "<secondItem>" to TextBox and press enter
    Then I should see "<secondItem>" item inserted to ToDo list below "<firstItem>"
    Examples:
      | firstItem     | secondItem           |
      | buy some milk | enjoy the assignment |

  @2
  Scenario Outline: I should be able mark item as DONE
    Given ToDo list with "<item>" item
    When I click on "checkBox" next to "<item>" item
    Then I should see "<item>" item marked as DONE
    Examples:
      | item          |
      | buy some milk |

  @3
  Scenario Outline: I should be able mark item as UNDONE
    Given ToDo list with marked "<item>" item
    When I click on "checkBox" next to "<item>" item
    Then I should see "<item>" item marked as UNDONE
    Examples:
      | item          |
      | buy some milk |

  @4
  Scenario Outline: I should be able to clear ToDo list
    Given ToDo list with "<item>" item
    When I click on "deleteButton" next to "<item>" item
    Then List should be empty
    Examples:
      | item             |
      | rest for a while |

  @5
  Scenario Outline: I should be able to delete one item
    Given ToDo list with "<item1>" and "<item2>" item in order
    When I click on "deleteButton" next to "<item1>" item
    Then I should see "<item2>" item in ToDo list
    Examples:
      | item1            | item2       |
      | rest for a while | drink water |
