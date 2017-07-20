Feature: WH SDET tests (junior)


  @Test @TestCase1
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


  @Test @TestCase2
  Scenario: TC2: Verify slip empty.
    Given I navigate to Spanish Sportsbook homepage
    And Validate "Cupon Vacio" is visible on each sport


  @Test @TestCase3
  Scenario: Verify customer help portal.
    Given I navigate to Spanish Sportsbook homepage
    And I mouse over on the link "Atención al Cliente"
    And I click on the link "Preguntas frecuentes"
    And I switch to next windows
    And I validate that the following URL is "https://williamhill-es.custhelp.com/app/answers/list"
    When I add each link from the rn_navigation bar in a list
    Then I validate that following links are present on the list
      |Preguntas Frecuentes|
      |Registro|
      |Mi cuenta|
      |Método de pagos|
      |Preguntas de Deportes|
      |Reglas de Deportes|
      |Preguntas de Casino|
      |Ayuda Técnica|
      |Juego Responsable|

