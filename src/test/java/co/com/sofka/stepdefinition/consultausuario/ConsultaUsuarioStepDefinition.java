package co.com.sofka.stepdefinition.consultausuario;


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

public class ConsultaUsuarioStepDefinition extends ServiceSetUp {

    public static final Logger LOGGER = Logger.getLogger(ConsultaUsuarioStepDefinition.class);
    private Response response;
    private RequestSpecification request;

    @Dado("el usuario esta en la pagina de busqueda de usuarios registrados")
    public void elUsuarioEstaEnLaPaginaDeBusquedaDeUsuariosRegistrados() {
        try {
            generalSetUp();
            request = given()
                    .log()
                    .all()
                    .contentType(ContentType.ANY);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Cuando("el usuario hace una peticion de busqueda")
    public void elUsuarioHaceUnaPeticionDeBusqueda() {
        try {
            response = request.when()
                    .get(SINGLE_USER_NOT_FOUND_RESOURCE);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Entonces("el usuario debera ver un codigo de respuesta exitoso y un token vacio")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaExitosoYUnTokenVacio() {
        try {
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_NOT_FOUND)
                    .body("",notNullValue());
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
