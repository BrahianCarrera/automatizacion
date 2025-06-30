package co.com.udea.shopping_cart.tasks;

import co.com.udea.shopping_cart.interactions.RealizeLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String username;
    private final String password;


    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(RealizeLogin.logInWith(username, password));
    }
}