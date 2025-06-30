package co.com.udea.shopping_cart.stepdefinitions;

import co.com.udea.shopping_cart.questions.ConfirmationMessage;
import co.com.udea.shopping_cart.tasks.ClickForgotPasswordLink;
import co.com.udea.shopping_cart.tasks.EnterUsernameRecovery;
import co.com.udea.shopping_cart.tasks.RecoverPassword;
import co.com.udea.shopping_cart.tasks.WaitForm;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebDriver;

import static co.com.udea.shopping_cart.userinterfaces.ForgotPasswordPage.COMFIRMATION_MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class ForgotPasswordDefinition {

    @Managed(driver="chrome")
    public WebDriver driver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario quiere recuperar su contraseña")
    public void userIsInTheLoginPage() {
        usuario.attemptsTo(
                Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
        );
    }

    @When("hace clic en el enlace 'Forgot Your Password'")
    public void clickForgotPasswordLink() {
        usuario.attemptsTo(ClickForgotPasswordLink.now());
    }

    @And("es redireccionado a la pagina de recuperar contraseña")
    public void redirectedToRecoveryPage() {
        usuario.attemptsTo(WaitForm.toBeVisible());
    }

    @And("ingresa su usuario")
    public void entersUsername() {
        usuario.attemptsTo(EnterUsernameRecovery.as("Admin"));
    }

    @Then("deberia de ver el mensaje que le indica que se le enviaron instrucciones al correo")
    public void seesConfirmationMessage() {
        usuario.should(
                seeThat(ConfirmationMessage.text(), containsString("Reset Password link sent successfully"))
        );
    }
}