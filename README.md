# Reto de automatización con Rest Assured
# Realizado por Carlos Fernando Rojas Cortés

En este proyecto se pretende realizar unas caracteristicas para una página de pruebas de consumo de servicios, para practicar conocimientos como:

* Uso de metodología BDD
* Uso de lenguaje DSL y herramientas como Gherkin para su manejo
* Uso de Cucumber y JUnit para las pruebas automatizadas
* Uso de gestores de log con log4j
* Buenas prácticas de programación en la contrucción del caso de negocio
* Uso de lenguaje descriptivo en terminos de negocio

Para esto se definen las siguientes secciones:
  1. [Configuración inicial](#configuración-inicial)
  2. [Requerimientos](#requerimientos)
  3. [Plan de pruebas](#plan-de-pruebas)


## Configuración inicial

Para poder correr las pruebas automatizadas se debe ubicar en la ruta src/test/java/co/com/sofka/runner y posteriormente

en cualquiera de los paquetes que se encuentran allí (consultausuario, login), en ellos encontrará ejecutables java

que serán los que correran las pruebas automatizadas.


## Requerimientos

Para usar este proyecto es necesario tener los siguientes plugins en un IDE que maneje Java como lo puede ser IntelliJ IDEA además de contar con JDK11:

■CucumberforJava
■Gherkin
■SubstepsIntellijPlugin
■Gradle
■Maven

y dependencias como:

implementation 'io.rest-assured:rest-assured:4.4.0'
implementation 'org.hamcrest:hamcrest-all:1.3'

implementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
implementation 'org.junit.jupiter:junit-jupiter-engine:5.8.1'

implementation 'io.cucumber:cucumber-junit:6.11.0'
implementation 'io.cucumber:cucumber-java:6.11.0'

implementation group: 'log4j', name: 'log4j', version: '1.2.17'


## Plan de pruebas

### 1. **Descripción del plan de pruebas**

El proyecto de la página reqres tiene como objetivo principal implementar una serie de funcionalidades en su página web que le permita a sus usuarios realizar funciones de logueo y busqueda de usuarios en específico.

Este plan de pruebas está enfocado a que el usuario mande unas peticiones y a partir de esto la página entregue unas respuestas esperadas del consumo del servicio.

### 2. **Alcance de las pruebas**

El alcance de las pruebas para el primer sprint incluye pruebas para los módulos de Log In y consulta de usuarios, basados en los siguientes criterios de aceptación:

1. Modulo "Log In"

*Verificar que cuando se ingresan las credenciales de un usuario registrado en la plataforma, el servicio responde con un código de respuesta exitoso y un token de ingreso.

2. Modulo "Consulta de usuarios"

*Verificar que cuando se consulta por la URL de un usuario que no exista en la plataforma, el servicio responde con un código de recurso no encontrado y un token vacío.

### **Fuera de alcance**

*No se verificará las otras funcionalidades del login, como login fallido.
*No se verficiará las otras funcionalidades de consulta de usuarios/recursos, como busqueda exitosa o lista de usuarios.
*No se verificarán otros módulos de la página web.

### 3. **Estrategia de las pruebas**

Las pruebas del primer sprint se realizarán de manera **automática**, estas se realizarán con ayuda de JUnit, Cucumber y RestAssured. Se realizarán funcionalidades preestablecidas para los módulos de Consulta de usuario y Log In.

### 4. Requerimientos

- Requerimos acceso al servicio de la plataforma web de la empresa.
- Documentación actualizada del proyecto.
- Comunicación constante con el equipo de trabajo.

### 5. Riesgos

A continuación se presenta una tabla con el análisis de riesgos para cada criterio de aceptación creados para los módulos en cuestión.

El análisis se realizó con una matriz de riesgos de 3x3, por lo tanto el menor nivel de riesgo será 1 y el mayor será 9.

| Criterio aceptación | Probabilidad | Impacto | Nivel de riesgo |
| --- | --- | --- | --- |
| CA_001 Verificar login exitoso | 2 | 3 | 6 |
| CA_002 Verificar consulta de usuario no encontrado | 2 | 1 | 2 |

### 6. Otros tipos de pruebas

Se recomienda al equipo realizar las siguientes pruebas:

- Pruebas de Rendimiento
- Pruebas de Seguridad

### 7. Equipo de trabajo

**Carlos Fernando Rojas Cortés** – Creador del plan de pruebas y automatizador