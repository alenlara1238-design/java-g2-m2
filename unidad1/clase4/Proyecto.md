#  Proyecto: API de Cálculo de Tarifas de Transporte (Tipo Uber)

## Propuesta
Desarrollar una API RESTful con Spring Boot que permita calcular el costo de un viaje en función del tipo de servicio seleccionado, aplicando buenas prácticas de arquitectura y el patrón de diseño Strategy.

---

## Contexto del negocio

Una empresa de transporte tipo Uber necesita calcular el costo de los viajes según diferentes modalidades de servicio:

-  Económico
-  Premium
-  Tarifa dinámica (hora pico)

Cada tipo de servicio tiene una forma distinta de calcular el costo del viaje.
El costo del viaje depende de dos factores principales:

 Distancia (en kilómetros)
 Duración (en minutos)
 Tarifa Económica (ECONOMY)
Costo por km: 1.0
Costo por minuto: 0.5

Fórmula:

Fare = 1.0 * distance + 0.5 * duration

 Es la opción más accesible, pensada para usuarios estándar.

 Tarifa Premium (PREMIUM)
Costo por km: 2.0
Costo por minuto: 1.0

Fórmula:

Fare = 2.0 * distance + 1.0 * duration

 Representa un servicio de mayor calidad (vehículos más cómodos, mejor experiencia).

 Tarifa Dinámica (SURGE)
Costo base incrementado:
km: 1.5
minuto: 0.75
Multiplicador de demanda: 1.5

Fórmula:

Fare = (1.5 * distance + 0.75 * duration) * 1.5

 Simula condiciones reales como:

##### Alta demanda (hora pico)
##### Lluvia
##### Escasez de conductores
##### Requerimientos funcionales
---

##  Requerimientos funcionales

1. La API debe permitir registrar un viaje.
2. La API debe calcular el costo del viaje según el tipo de tarifa.
3. La API debe listar los viajes registrados.
4. No se usará base de datos (se simulará con estructuras en memoria).

---

##  Requerimientos técnicos

### 1. Arquitectura por capas
El proyecto debe implementar:

- Controller (API REST)
- Service (lógica de negocio)
- Repository (simulado en memoria)

---

### 2. Uso del patrón Strategy

Se debe implementar una estrategia para cada tipo de tarifa:

- `EconomyFareStrategy`
- `PremiumFareStrategy`
- `SurgeFareStrategy`

Todas deben implementar una interfaz común:

```java
FareStrategy 
```

###  Ejemplo de entrada
```json
{
  "distance": 10,
  "duration": 15,
  "fareType": "ECONOMY",
  "userEmail": "test@mail.com"
}
```
### Ejemplo de salida
```json
{
  "id": 1,
  "totalFare": 25.0,
  "fareType": "ECONOMY"
}
```

---

# Estructura del proyecto
com.example.transportfare
│
├── controller
│ └── TripController.java
│
├── service
│ ├── TripService.java
│ └── FareStrategy.java
│ └── impl
│ ├── EconomyFareStrategy.java
│ ├── PremiumFareStrategy.java
│ └── SurgeFareStrategy.java
│
├── repository
│ └── TripRepository.java
│
├── model
│ ├── Trip.java
│ └── FareType.java
│
├── dto
│ └── TripRequest.java
│
└── TransportFareApplication.java

### Uso de Swagger 

Por último debe asegurarte de usar Swagger, agregando al archivo de dependencias Pom.xml:

```xml

		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.5.0</version>
		</dependency>

```

