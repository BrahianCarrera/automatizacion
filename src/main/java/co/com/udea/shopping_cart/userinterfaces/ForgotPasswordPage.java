package co.com.udea.shopping_cart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ForgotPasswordPage {

    public static final Target FORGOT_PASSWORD_LINK = Target.the("Forgot your password link").locatedBy("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");

    public static final Target SUBMIT = Target.the("Submit Forgot Password Button").locatedBy("//*[@id='app']/div[1]/div[1]/div/form/div[2]/button[2]");

    public static final Target USERINPUT = Target.the("Input to recover password").locatedBy("//*[@id='app']/div[1]/div[1]/div/form/div[1]/div/div[2]/input");

    public static final Target COMFIRMATION_MESSAGE = Target.the("Message of successfull request").locatedBy("//*[@id='app']/div[1]/div[1]/div/h6");




}
