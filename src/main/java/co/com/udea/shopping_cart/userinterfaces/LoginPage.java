package co.com.udea.shopping_cart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERINPUT = Target.the("Username text input")
            .located(By.name("username"));

    public static final Target PASSWORD = Target.the("Password text input")
            .located(By.name("password"));

    public static final Target LOGINBUTTON = Target.the("Login Button ")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target DASHBOARD_HEADER = Target.the("Dashboard Header")
            .located(By.xpath("//h6[text()='Dashboard']"));

    public static final Target ERROR_MESSAGE = Target.the("Error Message").locatedBy("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");



}