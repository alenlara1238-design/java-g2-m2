## Ejercicio 1: Sistema de Alerta de "Cripto-Ballenas" (Fintech Simulado)

Escenario: Debe crear un servicio que reciba transacciones de criptomonedas y genere una alerta si la transacción es sospechosa (un monto muy alto realizado por una cuenta no verificada).

#### A. Estructura de Carpetas Sugerida
```plainText
src/main/java/com/escuela/cripto
├── controller
│   └── TransaccionController.java
├── service
│   └── TransaccionService.java
├── repository
│   └── TransaccionRepository.java
└── model
    └── Transaccion.java
````
#### B. Especificaciones del Modelo (Transaccion)
* String id (UUID)

* String walletOrigen

* Double monto

* Boolean cuentaVerificada

* String categoria (Ej: "NORMAL", "ALERTA_BALLENA", "RIESGO")

#### C. Métodos a definir en el @Service
`1. procesarTransaccion(Transaccion t):`
* Lógica: Usar un if o Stream para evaluar: Si el monto es $> 10,000$ y la cuenta no está verificada, cambiar la categoría a "ALERTA_BALLENA".

* Debe llamar al repositorio para guardar.

`2. obtenerTransaccionesRiesgosas():`

* Lógica con Streams: repository.findAll().stream().filter(t -> t.getMonto() > 50000).collect(...).


## Ejercicio 2: Gestor de "Streaming de Música" (Modo Offline)

Escenario: Un servicio que gestiona una lista de reproducción. El objetivo es que practiquen cómo el servicio "enriquece" la información antes de mostrarla al usuario.

### A. Estructura de Carpetas Sugerida


src/main/java/com/escuela/musica
├── controller
│   └── PlaylistController.java
├── service
│   └── MusicaService.java
├── repository
│   └── MusicaRepository.java
└── model
    └── Cancion.java


### B. Especificaciones del Modelo (Cancion)
* Long id

* String titulo

* String artista

* Integer duracionSegundos

* Boolean esPremium

### C. Métodos a definir en el @Service
```1. agregarCancion(Cancion c):```

* **Lógica:** Validar que el título y el artista no estén vacíos antes de enviar al repositorio.

```2. obtenerPlaylistParaUsuarioGratis():```

* **Lógica con Streams:** Filtrar la lista del repositorio para excluir aquellas donde esPremium == true.

```3. calcularTiempoTotal():```

* **Lógica con Streams:** Usar ```stream().mapToInt(Cancion::getDuracionSegundos).sum()``` para devolver la duración total de la playlist en minutos.


Para ambos ejercicios, sigan este orden de construcción:

1. Capa Model: Crear el POJO con sus constructores y getters.

2. Capa Repository: Crear la clase con @Repository y una List privada para simular la base de datos. Recuerda incluir el método para obtener las "reglas" (como la lista de cuentas verificadas o canciones premium).

3. Capa Service: Crear el constructor que reciba el repositorio. Aquí es donde deben brillar con los Java Streams.

4. Capa Controller: Crear los métodos @PostMapping y @GetMapping que invoquen al servicio.
