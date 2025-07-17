@Full
Feature: Agregar y remover producto del carrito de compra


    Scenario: Flujo de compra Iphone
        Given busco el producto "iphone"
        When selecciono el primer producto
        And agrego el producto iPhone al carrito
        And hago click en el boton del carrito superior
        And selecciono el boton View Cart
        Then valido que el producto iPhone este en el carrito
        When remuevo el producto del carrito
        And valido que el producto iPhone no este en el carrito

    