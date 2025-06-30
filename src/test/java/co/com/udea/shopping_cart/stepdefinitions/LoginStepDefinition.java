package co.com.udea.shopping_cart.stepdefinitions;

import co.com.udea.shopping_cart.questions.LoginErrorMessage;
import co.com.udea.shopping_cart.questions.LoginValidation;
import co.com.udea.shopping_cart.tasks.Login;
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

    @Managed(driver="chrome")
    public WebDriver driver;

    private Actor usuario = Actor.named("usuario");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario esta en la pagina de login de OrangeHRM")
    public void userIsInTheLoginPage() {

        usuario.attemptsTo(
                Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
        );
    }

    @When("intenta iniciar sesion con su nombre de usuario {string} y su contraseña {string}")
    public void userAttemptsToLogin( String username, String password) {
        usuario.attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @Then("deberia ver el encabezado del dashboard")
    public void userShouldSeeDashboardHeader( ) {

        then(usuario).should(
                seeThat(LoginValidation.dashboardHeader(), equalTo("Dashboard"))
        );
    }

    @Then("deberia de ver el mensaje de error 'Invalid credentials'")
    public void userShouldSeeErrorMessage( ) {
        then(usuario).should(seeThat(LoginErrorMessage.displayed(), equalTo("Invalid credentials")));
    }

}