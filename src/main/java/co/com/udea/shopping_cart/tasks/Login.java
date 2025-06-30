package co.com.udea.shopping_cart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static co.com.udea.shopping_cart.userinterfaces.UserInterface.*;

public class Login implements Task { // Cambiado a 'Login' y es una Task directamente

    private final String username;
    private final String password;

    // Constructor para recibir credenciales
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Método estático para instrumentar la tarea (patrón Screenplay)
    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }

    @Override

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(USERINPUT),
                Enter.theValue(password).into(PASSWORD),
                Click.on(LOGINBUTTON)
        );
    }
}