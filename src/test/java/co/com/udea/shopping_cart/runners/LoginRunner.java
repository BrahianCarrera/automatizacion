package co.com.udea.shopping_cart.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/loginfeature/login.feature",
        glue = "co.com.udea.shopping_cart.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class LoginRunner {}