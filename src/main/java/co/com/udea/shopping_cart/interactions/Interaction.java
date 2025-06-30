package co.com.udea.shopping_cart.interactions;

import co.com.udea.shopping_cart.tasks.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import org.openqa.selenium.Keys;

import static co.com.udea.shopping_cart.userinterfaces.UserInterface.*;

public class Interaction implements net.serenitybdd.screenplay.Interaction {

    @Override
    public <T extends Actor> void performAs(T t) {

        t.attemptsTo(Enter.theValue("Admin").into(USERINPUT));
        t.attemptsTo(Enter.theValue("admin123").into(PASSWORD));
        Click.on(LOGINBUTTON);
    }

    public static Interaction LogIn() {return Tasks.instrumented(Interaction.class);}
}