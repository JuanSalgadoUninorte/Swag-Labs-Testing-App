Feature: Source Labs App
  As a user of SauceLabs,
  I want to place an order,
  So I can choose the items that I want

  Scenario Outline: Place an order
    Given Access to the app
    When He logs in into the app
      | user   | password   |
      | <user> | <password> |
    And Choses the items and places the info
      | infoName   | infoLast   | postal   |
      | <infoName> | <infoLast> | <postal> |
    Then He comfirms that the order is already placed
      | message   |
      | <message> |
    Examples:
      | user          | password     | infoName | infoLast | postal | message                 |
      | standard_user | secret_sauce | Eustace  | Scubb    | 658541 | THANK YOU FOR YOU ORDER |