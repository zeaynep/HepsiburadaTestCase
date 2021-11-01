Feature: Login Feature
  Scenario: Successful Login Test
    Given I have opened "https://giris.hepsiburada.com/"
    When I fill the username field with username as "CORRECTUSER" AND password as "CORRECTPASSWORD"
    Then I have seen the home page

  Scenario: Unsuccessful Login Test
    Given I have opened "https://giris.hepsiburada.com/"
    When I fill the username field with username as "WRONGUSER" OR password as "WRONGPASSWORD"
    Then I have stayed at registration page