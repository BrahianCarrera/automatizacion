package co.com.udea.shopping_cart.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.shopping_cart.userinterfaces.ForgotPasswordPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;



public class ClicForgotPassword implements Interaction {

    private final String username;


    public ClicForgotPassword(String username) {
        this.username = username;
    }

    public static ClicForgotPassword now(String username) {
        return Tasks.instrumented(ClicForgotPassword.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FORGOT_PASSWORD_LINK),
                WaitUntil.the(SUBMIT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(USERINPUT),
                Click.on(SUBMIT)
        );
    }
}