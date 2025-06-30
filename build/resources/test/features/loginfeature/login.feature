Feature: Login functionality

  Scenario: Successful login with valid credentials to OrangeHRM
    Given esta en la pagina de login de OrangeHRM
    When intenta iniciar sesion con el usuario "Admin" y la contraseña "admin123"
    Then deberia ver el encabezado del dashboard "Dashboard"