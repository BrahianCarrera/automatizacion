package co.com.udea.shopping_cart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.udea.shopping_cart.userinterfaces.LoginPage.DASHBOARD_HEADER; // Usar el nuevo Target

public class LoginValidation implements Question<String> {

    private LoginValidation() {}

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(DASHBOARD_HEADER).answeredBy(actor);
    }

    public static LoginValidation dashboardHeader() {
        return new LoginValidation();
    }

}