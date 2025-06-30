package co.com.udea.shopping_cart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserInterface {

    // Selectores actualizados para OrangeHRM Live (verificado a 2024-06-29)
    public static final Target USERINPUT = Target.the("Username text input")
            .located(By.name("username")); // Por nombre del atributo 'name'

    public static final Target PASSWORD = Target.the("Password text input")
            .located(By.name("password")); // Por nombre del atributo 'name'

    public static final Target LOGINBUTTON = Target.the("Login Button ")
            .located(By.xpath("//button[@type='submit']")); // Botón de tipo submit

    // Selector para el encabezado después del login (ej: "Dashboard" o "Time")
    // Necesitas verificar cuál es el texto que aparece consistentemente después del login.
    // En OrangeHRM, el título de la página principal (Dashboard) es un buen indicador.
    public static final Target DASHBOARD_HEADER = Target.the("Dashboard Header")
            .located(By.xpath("//h6[text()='Dashboard']")); // XPath que busca un h6 con el texto 'Dashboard'
    // Si tu demo muestra otra cosa, actualiza el texto aquí.
}