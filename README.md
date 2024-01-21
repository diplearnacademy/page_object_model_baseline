### Proyecto base  Patrón Page Object Model

Este proyecto implementa Selenium  usando el patrón POM  ademas de otras librerias  como Junit para los runner de los escenarios, Cucumber para trabajar escenarios con lenguaje Gherkin, extentReport para el manejo de reportes y ademas una implementacion de un drivermanager para configurar el proyecto por medio de un archivo properties


- Rama **main**: Esta rama contiene una estructura basica con las dependencias y un ejemplo  de los metodos de Selenium
- Rama **cucumber_pom**: Esta rama contiene la implementacion de un  escenarios de automatizacion en la pagina de Airbnb  usando cucumber y el patrón POM                     https://www.airbnb.com.co/
- Rama **page_factory**: Esta rama contiene  un escenario  donde se implementa el  patrón Page Factory para manejar los webElements de selenium
- Rama **teststorage**: Esta rama contiene  un escenario en una nueva pagina   donde se implementa el POM con selenium  en la pagina : http://teststore.automationtesting.co.uk/

#### Consideraciones
- cada rama tiene incluida  el chromedrver o el edgedriver con la version 120.0 de los respectivos navegadores  verifique que su navegador tiene esta version en el caso de tener una version diferente
  actualice en la carpeta  `RUTA_DEL_PRUYECTO/src/test/java/resource/drivers` el driver correspondiente a la versión de su navegador

- chrome: https://chromedriver.chromium.org/downloads/version-selection
- Edge : https://developer.microsoft.com/es-es/microsoft-edge/tools/webdriver/?form=MA13LH#downloads

####  Ejecuccion con Gradle

- Abrir una terminal en la ubicacion del proyecto  y ejecutar el siguiente comando

  `gradle clean test`
  o
  `./gradlew clean test`
  si quieres ver la trazabilidad de la ejcución, anade al comando que vas a ejecutar

  `--info --stacktrace`

- si quiere ejecutar los escenarios de forma independiente puede usar las opcines del IDE en cada clase
#### Revisión de resultado

Gradle genera un reporte en HTML para revisar este reporte ve a la siguiente ruta

`RUTA_DEL_PRUYECTO/page_object_model_baseline\test-output`

### Happy Coding!


------------

#### Diplomado de Automatización de Pruebas Web
##### Dip Learn Academy y AseUTP
##### Juan de Jesús Fernández Graciano
##### Bryan Estefan Moreno Diaz