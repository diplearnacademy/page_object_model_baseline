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
    Then verifica que el producto fue anadido al carrito

  Scenario: Selección de productos
    Given Que el usuario esta en la pagina principal
    When Agrega los productos con sus caracteristicas al carrito
      |producto|caracteristica|cantidad|
      |        |              |        |
    Then verifica que los productos fueron agregados al carrito
