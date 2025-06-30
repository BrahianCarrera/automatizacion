package co.com.udea.shopping_cart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.shopping_cart.userinterfaces.ForgotPasswordPage.USERINPUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WaitForm implements Task {
    public static WaitForm toBeVisible() {
        return instrumented(WaitForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(USERINPUT, isVisible()).forNoMoreThan(10).seconds());
    }
}