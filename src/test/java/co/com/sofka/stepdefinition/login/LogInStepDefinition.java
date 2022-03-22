package co.com.sofka.stepdefinition.login;

import co.com.sofka.stepdefinition.setup.services.ServiceSetUp;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class LogInStepDefinition extends ServiceSetUp {

    public static final Logger LOGGER = Logger.getLogger(LogInStepDefinition.class);
    private Response response;
    private RequestSpecification request;

    @Dado("el usuario esta en la pagina de inicio de sesion con el correo de usuario {string} y la contrasena {string}")
    public void elUsuarioEstaEnLaPaginaDeInicioDeSesionConElCorreoDeUsuarioYLaContrasena(String email, String password) {
        try {
            generalSetUp();
            request = given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "    \"email\": \"" + email + "\",\n" +
                            "    \"password\": \"" + password + "\"\n" +
                            "}");
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Cuando("el usuario hace una peticion de inicio")
    public void elUsuarioHaceUnaPeticionDeInicio() {
        try {
            response = request.when()
                    .post(LOGIN_RESOURCE);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Entonces("el usuario debera ver un codigo de respuesta exitoso y un token de respuesta")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaExitosoYUnTokenDeRespuesta() {
        try {
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("token", notNullValue());
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
