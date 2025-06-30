package co.com.udea.shopping_cart.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.udea.shopping_cart.userinterfaces.ForgotPasswordPage.COMFIRMATION_MESSAGE;

public class ConfirmationMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(COMFIRMATION_MESSAGE).answeredBy(actor);
    }

    public static ConfirmationMessage text() {
        return new ConfirmationMessage();
    }
}