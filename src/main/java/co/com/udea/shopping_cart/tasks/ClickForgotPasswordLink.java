package co.com.udea.shopping_cart.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.shopping_cart.userinterfaces.ForgotPasswordPage.FORGOT_PASSWORD_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickForgotPasswordLink implements Task {
    public static ClickForgotPasswordLink now() {
        return instrumented(ClickForgotPasswordLink.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FORGOT_PASSWORD_LINK));
    }
}