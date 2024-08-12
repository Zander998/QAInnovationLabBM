@AllTest
Feature: Product Store

  @ProductCar
  Scenario: Validación del Precio de un Producto
    Given estoy en la página de la tienda y me logueo con mi usuario "bryan.alex998@hotmail.com" y clave "clave2025"
    When navego a la categoría 'Clothes' y subcategoría 'Men'
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el título de la página del carrito
    And vuelvo a validar el cálculo de precios en el carrito

  @LoginFail
  Scenario: Inicio de sesión inválido
    Given estoy en la página de la tienda y me logueo con mi usuario "bryan.alex998@hotmail.com" y clave "12345"