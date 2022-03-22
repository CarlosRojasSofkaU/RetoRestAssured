package co.com.sofka.runner.consultausuario;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/consultausuario/consultaUsuarioEspecifico.feature"},
        glue = {"co.com.sofka.stepdefinition.consultausuario"},
        tags = ""
)
public class ConsultaUsuarioTest {
}
