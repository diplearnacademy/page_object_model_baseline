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


  Scenario: Selección de productos con una sola característica
    Given  Que el usuario esta en la pagina principal
    When Agrega los productos con sus caracteristicas al carrito
      | Producto                | caracteristicas        | Cantidad |
      | sweater                 | Talla: M               | 2        |
      | The best is yet to come | Dimension: 60x90cm     | 2        |
      | Hummingbird printed     | Talla: L, Color: Negro | 2        |
    Then verifica que los productos fueron agregados al carrito

