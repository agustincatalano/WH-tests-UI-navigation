Feature: WH SDET tests (junior)


  @Test
  Scenario: TC1: Simple navigation and validation.
    Given I navigate to Spanish Sportsbook homepage
    When I add each event listed on the top page in a list
    Then I validate that following events are present on the list
      |Apuestas Deportivas|
      |Apuestas En Directo|
      |Casino|
      |Casino en Vivo|
      |Móvil|
    And I Validate that each event contains "Juego responsable" link


  @Test
  Scenario: TC2: Verify slip empty.
    Given I navigate to Spanish Sportsbook homepage
    And Validate "Cupon Vacio" is visible on each sport

