Feature: Prueba simple de Karate

  Background:
    * url 'https://reqres.in/'

  @CP1
  Scenario: Validar respuesta de usuario numero 2

    Given path '/api/user/2'
    And def body_request = read('classpath:singleUserSucces.json')
    And request body_request
    When method GET
    Then status 200
    And match response.data.id == 2

  @CP2
  Scenario: Validar respuesta de usuario numero 2 con respuesta incorrecta

    Given path '/api/user/2'
    And def body_request = read('classpath:singleUserSucces.json')
    And request body_request
    When method GET
    Then status 201

  @CP3
  Scenario: Validar respuesta usuairo fallido

    Given path '/api/users/23'
    When method GET
    Then status 404

  @CP4
  Scenario: Validar respuesta usuairo fallido con respuesta 200

    Given path '/api/users/23'
    When method GET
    Then status 200

  @CP5
  Scenario: Validar respuesta de crear usuairo

    Given path '/api/user'
    And def body_request = read('classpath:createUserSuccess.json')
    And request body_request
    When method POST
    Then status 201
    And match response.name == 'morpheus'

  @CP6
  Scenario: Validar respuesta de login exitoso
    Given path '/api/login'
    And def body_request = read('classpath:loginSuccessfulSuccess.json')
    And request body_request
    When method POST
    Then status 200
    And match response.token == 'QpwL5tke4Pnpja7X4'

  @CP7
  Scenario: Validar respuesta de login fallido
    Given path '/api/login'
    And def body_request = read('classpath:loginSuccessFail.json')
    And request body_request
    When method POST
    Then status 400
    And match response.error == 'user not found'
