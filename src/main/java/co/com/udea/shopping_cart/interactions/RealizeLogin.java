package co.com.udea.shopping_cart.interactions;

import co.com.udea.shopping_cart.tasks.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import org.openqa.selenium.Keys;

import static co.com.udea.shopping_cart.userinterfaces.UserInterface.*;

public class Interaction implements net.serenitybdd.screenplay.Interaction {

    private final String username;
    private final String password;

    public Interaction(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(USERINPUT),
                Enter.theValue(password).into(PASSWORD),
                Click.on(LOGINBUTTON)
        );
    }

    public static Interaction logInWith(String username, String password) {
        return Tasks.instrumented(Interaction.class, username, password);
    }
}
