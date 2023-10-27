Feature: Seleccion de Producto
  Como usuario
  Quiero Seleccionar un producto
  segun su Talla, color y cantidad
  para agregarlo al carrito de compras

  Scenario: Selección correcta
    Given Que el usuario esta en la pagina principal
    When Selecciona un producto
    And Selecciona su <dim>, <color> y <cantidad>
    And El usuario agrega el producto al carrito
    Then verifica que el producto fue añadido al carrito
