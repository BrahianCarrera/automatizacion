package co.com.udea.shopping_cart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.udea.shopping_cart.userinterfaces.ForgotPasswordPage.SUBMIT;
import static co.com.udea.shopping_cart.userinterfaces.ForgotPasswordPage.USERINPUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterUsernameRecovery implements Task {
    private final String username;

    public EnterUsernameRecovery(String username) {
        this.username = username;
    }

    public static EnterUsernameRecovery as(String username) {
        return instrumented(EnterUsernameRecovery.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(USERINPUT),
                Click.on(SUBMIT)
        );
    }
}
