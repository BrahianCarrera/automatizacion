package co.com.udea.shopping_cart.tasks;

import co.com.udea.shopping_cart.interactions.ClicForgotPassword;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RecoverPassword implements Task {

    private final String username;

    public RecoverPassword(String username) {
        this.username = username;
    }

    public static RecoverPassword withUsername (String username) {
        return instrumented(RecoverPassword.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ClicForgotPassword.now(username)
        );
    }
}