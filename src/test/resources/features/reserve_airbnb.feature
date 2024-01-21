Feature:  reserva de estadia Airbnb



  Scenario: Realizar reserva y ver precio
    Given que Bryan se encuentra en la pagina de Airbnb
    When  busca una estancia en la ciudad de "Santa marta"
    And   seleciona las fechas de estancia  del "15 Marzo 2024" hasta el "30 Marzo 2024"
    And   especifica una ocupacion para 4 "adultos"
    And   especifica una ocupacion para 2 "ninos"
    And   elige la primera opcion mostrada en la reseva
    Then  puede ver el precio correspondiente a la estancia reservada



