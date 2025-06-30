Feature: Login functionality

  Scenario: Inicio de sesión exitoso con credenciales correctas
    Given el usuario esta en la pagina de login de OrangeHRM
    When intenta iniciar sesion con su nombre de usuario "Admin" y su contraseña "admin123"
    Then deberia ver el encabezado del dashboard

  Scenario: Inicio de sesión fallido con credenciales incorrectas
    Given el usuario esta en la pagina de login de OrangeHRM
    When intenta iniciar sesion con su nombre de usuario "noAdmin" y su contraseña "admin123"
    Then deberia de ver el mensaje de error 'Invalid credentials'

    Scenario: Recuperacion de contraseña
      Given el usuario quiere recuperar su contraseña
      When hace clic en el enlace 'Forgot Your Password'
      And es redireccionado a la pagina de recuperar contraseña
      And ingresa su usuario
      Then deberia de ver el mensaje que le indica que se le enviaron instrucciones al correo
