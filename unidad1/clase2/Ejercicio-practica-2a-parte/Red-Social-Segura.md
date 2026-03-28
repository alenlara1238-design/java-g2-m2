## Enunciado: Sistema de Moderación Automática "SafeTalk"
Contexto:
Vas a desarrollar el backend de una red social que busca mantener un ambiente sano. El sistema debe permitir que los usuarios envíen publicaciones, pero antes de ser almacenadas, deben pasar por un "Moderador Automático" (Capa de Servicio).

Requerimientos Funcionales:

* Validación de Contenido: El sistema debe detectar si un post contiene "palabras prohibidas" que provienen de la base de datos (simulada).

* Sanitización: Si se detecta una palabra prohibida, el sistema no rechaza el post, sino que lo "limpia" reemplazando dichas palabras por asteriscos (****) y marca el post como "Moderado".

* Filtrado de Feed: Debe existir un endpoint que devuelva únicamente los posts que son "Seguros" (aquellos que no tuvieron que ser moderados).

Reglas Técnicas:

* Uso estricto de @RestController, @Service y @Repository.


* Inyección de dependencias mediante Constructor (sin @Autowired en atributos).

* Uso de Java Streams para el filtrado y detección de palabras.

* Capa de datos simulada en memoria.