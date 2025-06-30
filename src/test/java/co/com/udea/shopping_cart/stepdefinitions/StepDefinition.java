package co.com.udea.shopping_cart.stepdefinitions;

import co.com.udea.shopping_cart.questions.LoginValidation;
import co.com.udea.shopping_cart.tasks.Login; // Usar la nueva Task Login
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinition {

    // Ya no necesitas inyectar WebDriver manualmente, Serenity lo hace.
    @Managed(driver="chrome")
    public WebDriver driver;

    // Ya no necesitas declarar el Actor aquí, se obtiene del OnStage.
    private Actor usuario = Actor.named("usuario");


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(driver));
    }

    // --- Scenario: Successful login with valid credentials ---
    @Given("esta en la pagina de login de OrangeHRM")
    public void userIsInTheLoginPage() {


        usuario.attemptsTo(
                Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
        );
    }

    @When("intenta iniciar sesion con el usuario {string} y la contraseña {string}")
    public void userAttemptsToLogin( String username, String password) {
        usuario.attemptsTo(
                Login.withCredentials(username, password) // Usar la Task Login con credenciales
        );
    }

    @Then("deberia ver el encabezado del dashboard {string}")
    public void userShouldSeeDashboardHeader( String expectedHeader) {
        // Asegúrate de que el texto del encabezado coincida exactamente con lo que aparece en la UI después del login
        then(usuario).should(
                seeThat(LoginValidation.dashboardHeader(), equalTo(expectedHeader))
        );
    }

    // --- Scenario: Unsuccessful login with invalid credentials ---
    // (Añadir un nuevo Then para mensajes de error si tu Gherkin lo requiere)
    // @Then("{word} deberia ver un mensaje de error {string}")
    // public void userShouldSeeErrorMessage(String actorName, String expectedErrorMessage) {
    //     // Necesitas un Target para el mensaje de error en UserInterface
    //     // Y una Question para leer ese mensaje
    //     // then(OnStage.theActorCalled(actorName)).should(
    //     //         seeThat(LoginFeedback.errorMessage(), equalTo(expectedErrorMessage))
    //     // );
    // }

    // --- Los steps para el carrito de compras irían aquí ---
    @Given("Estoy en la pagina que contiene los productos")
    public void estoy_en_la_pagina_que_contiene_los_productos() {
        // Este Given ya no se ajusta al flujo de login
        // Deberías cambiarlo a algo como:
        // userIsInTheLoginPage("usuario") // O un nombre de actor
        // userAttemptsToLogin("usuario", "Admin", "admin123")
        // Y luego continuar con las acciones del carrito
        // O si ya estás logueado en la misma sesión, simplemente navega a la página de productos si es necesario.
    }

    @When("cuando le doy clic al boton añadir al carrito")
    public void leDoyClickAlBoton(){
        //todo task para añadir al carrito
    }

    @Then("el item es agregado al carrito de compras")
    public void seAgrega(){
        //todo task para verificar que se agregó
    }
}