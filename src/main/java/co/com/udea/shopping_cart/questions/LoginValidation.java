package co.com.udea.shopping_cart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility; // Para verificar visibilidad

import static co.com.udea.shopping_cart.userinterfaces.UserInterface.DASHBOARD_HEADER; // Usar el nuevo Target

public class LoginValidation implements Question<String> { // Implementa Question<String> directamente

    // Constructor privado para el patrón singleton/instrumented
    private LoginValidation() {}

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(DASHBOARD_HEADER).answeredBy(actor);
    }

    public static LoginValidation dashboardHeader() {
        return new LoginValidation(); // Simplemente crea una nueva instancia
    }

}