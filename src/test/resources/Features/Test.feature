@test
Feature: Acceptance test1

  Background:
    * User navigated to ToDo application

  Scenario Outline: I should be able to add "<item>" to empty ToDo list
    Given Empty ToDo list
    When I write "<item>" to TextBox and press enter
    Then I should see "<item>" item in ToDo list
    Examples:
  | item                                                                                                                                       |
  | buy some milk                                                                                                                              |
  | second item to do including numbers 0123456789                                                                                             |
  | third item to do including special characters é!'^^+%&/()=?_<>£#$½§{[]}\|                                                                  |
  | fourth item to do including turkish characters şçğüıö                                                                                      |
  | fifth item to do with a very very long text, this guy has a job with a too long text and dont know how to do because it is a very long job |

