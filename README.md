## Entorno de análisis
Se selecciona Docker local por ser el proyecto lo suficientemente pequeño o poco exigente como para que resulte razonable analizarlo localmente, ademas de la mayor libertad que supone no estar bajo el servicio gratuito de SonarCloud.

## Estado inicial del análisis
| Métrica | Valor real observado |
|---------|----------------------|
| Complejidad ciclomática de calcularCosto() | 20 |
| Cobertura de líneas de ServicioCalculoEnvio | 23.8% |
| Cobertura de ramas de ServicioCalculoEnvio | 18.4% |
| Code Smells reportados | 0 |

## Interpretación
En la sección Measures → Complexity se evidencia que el método calcularCosto() de la clase ServicioCalculoEnvio presenta una complejidad ciclomática de 20, la más alta del proyecto. Esta misma clase registra una cobertura de líneas del 23,8 % (10/42) y una cobertura de ramas del 18,4 % (7/38). Ambos resultados reflejan aspectos distintos del método: mientras la complejidad ciclomática evidencia la cantidad de caminos independientes de ejecución, la cobertura muestra que las pruebas actuales ejercitan una proporción reducida de las ramas disponibles. Aunque ambas métricas están relacionadas, pues una complejidad ciclomática alta implica más caminos independientes que considerar al diseñar las pruebas, no implica necesariamente una cobertura baja, ya que esta también depende de las pruebas diseñadas y ejecutadas.

La métrica utilizada como señal principal fue la complejidad ciclomática, pues permite valorar la complejidad del comportamiento del método a partir de sus caminos independientes de ejecución, los cuales deben considerarse al verificar sus resultados. En este caso, su valor de 20, junto con la baja cobertura de ramas, refuerza la decisión de priorizarlo para una intervención. La cobertura, sin embargo, refleja principalmente cuánto se ha ejercitado mediante las pruebas y no permite determinar por sí sola si el diseño del método es deficiente. Por su parte, aunque la complejidad cognitiva también permite identificar dificultades que podrían justificar una intervención, se centra en la dificultad de comprender el código, mientras que la complejidad ciclomática aporta un criterio más directamente relacionado con los caminos de ejecución que deben verificarse. Por ello, se selecciona esta última como señal principal, sin descartar las demás métricas como información complementaria.

## Capturas del análisis inicial
![Dashboard SonarQube](docs/sonar-dashboard-inicial.png)
![Reporte JaCoCo](docs/jacoco-inicial.png)

