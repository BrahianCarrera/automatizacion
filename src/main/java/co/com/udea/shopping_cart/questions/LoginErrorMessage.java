package co.com.udea.shopping_cart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static co.com.udea.shopping_cart.userinterfaces.LoginPage.ERROR_MESSAGE;

public class LoginErrorMessage implements Question<String> {

    private LoginErrorMessage() {}

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ERROR_MESSAGE).answeredBy(actor);
    }

    public static LoginErrorMessage displayed() {
        return new LoginErrorMessage();
    }
}

