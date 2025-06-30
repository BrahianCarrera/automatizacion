package co.com.udea.shopping_cart.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.udea.shopping_cart.userinterfaces.LoginPage.*;

public class RealizeLogin implements net.serenitybdd.screenplay.Interaction {

    private final String username;
    private final String password;

    public RealizeLogin(String username, String password) {
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

    public static RealizeLogin logInWith(String username, String password) {
        return Tasks.instrumented(RealizeLogin.class, username, password);
    }
}
