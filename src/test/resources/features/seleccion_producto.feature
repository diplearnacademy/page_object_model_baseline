Feature: Seleccion de Producto
  Como usuario
  Quiero Seleccionar un producto
  segun su Talla, color y cantidad
  para agregarlo al carrito de compras


  Scenario: Selección de productos con una sola característica
    Given  Que el usuario esta en la pagina principal
    When Agrega los productos con sus caracteristicas al carrito
      | Producto                | caracteristicas        | Cantidad |
      | sweater                 | Talla: M               | 2        |
      | The best is yet to come | Dimension: 60x90cm     | 2        |
      | Hummingbird printed     | Talla: L, Color: Negro | 2        |
    Then verifica que los productos fueron agregados al carrito

