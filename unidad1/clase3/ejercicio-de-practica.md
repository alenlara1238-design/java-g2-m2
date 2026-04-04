# 1. Sistema de Procesamiento de Pagos

## Contexto

Se requiere desarrollar un sistema backend utilizando Spring Boot que permita gestionar y procesar pagos de diferentes tipos. El sistema debe estar estructurado en capas (controller, service y repository simulado) y debe aplicar principios SOLID en su diseño.

## Requerimientos funcionales

El sistema debe permitir:

1. Registrar pagos con la siguiente información:
   - ID
   - monto
   - tipo de pago (tarjeta, efectivo, transferencia)

2. Listar todos los pagos registrados.

3. Procesar un pago según su tipo:
   - Tarjeta: aplica comisión del 5%
   - Efectivo: no tiene comisión
   - Transferencia: aplica comisión del 2%

4. Calcular el monto final luego de aplicar la comisión correspondiente.

## Requerimientos técnicos

- Implementar arquitectura por capas:
  - Controller
  - Service
  - Repository (simulado en memoria)

- Aplicar principios SOLID:
  - SRP: cada clase debe tener una única responsabilidad
  - OCP: el sistema debe permitir agregar nuevos tipos de pago sin modificar código existente
  - LSP: los tipos de pago deben ser intercambiables
  - DIP: el servicio debe depender de abstracciones, no de implementaciones concretas

- Usar Streams cuando sea apropiado (por ejemplo, para cálculos o filtrado de datos).

## Restricciones

- No usar base de datos (usar estructuras en memoria)
- Mantener el código simple y claro 


# 2. Sistema de Envíos (Logística de Paquetes)

## Contexto

Se requiere desarrollar un sistema backend utilizando Spring Boot que permita gestionar envíos de paquetes. El sistema debe estar estructurado en capas (controller, service y repository simulado) y aplicar principios SOLID en su diseño.

## Requerimientos funcionales

El sistema debe permitir:

1. Registrar envíos con la siguiente información:
   - ID
   - peso del paquete
   - destino
   - tipo de envío (estándar, express, internacional)

2. Listar todos los envíos registrados.

3. Calcular el costo de un envío según su tipo:
   - Estándar: costo base fijo
   - Express: costo base + recargo por rapidez
   - Internacional: costo base + recargo por distancia

4. Obtener el costo total de todos los envíos registrados.

## Requerimientos técnicos

- Implementar arquitectura por capas:
  - Controller
  - Service
  - Repository (simulado en memoria)

- Aplicar principios SOLID:
  - SRP: cada clase debe tener una única responsabilidad
  - OCP: permitir agregar nuevos tipos de envío sin modificar código existente
  - LSP: los tipos de envío deben ser intercambiables
  - DIP: el servicio debe depender de abstracciones

- Usar Streams cuando sea apropiado para cálculos y consultas.

## Restricciones

- No usar base de datos
- Mantener el código simple y claro

# 3. Sistema de Notificaciones Multicanal

## Contexto

Se requiere desarrollar un sistema backend en Spring Boot que permita enviar notificaciones a usuarios a través de diferentes canales. El sistema debe estar organizado en capas y aplicar principios SOLID.

## Requerimientos funcionales

El sistema debe permitir:

1. Registrar notificaciones con la siguiente información:
   - ID
   - mensaje
   - destinatario
   - tipo de notificación (email, SMS, push)

2. Listar todas las notificaciones registradas.

3. Enviar una notificación según su tipo:
   - Email: simular envío por correo
   - SMS: simular envío por mensaje de texto
   - Push: simular notificación móvil

4. Consultar las notificaciones enviadas exitosamente.

## Requerimientos técnicos

- Implementar arquitectura por capas:
  - Controller
  - Service
  - Repository (simulado en memoria)

- Aplicar principios SOLID:
  - SRP: separar la lógica de envío de la gestión de datos
  - OCP: permitir agregar nuevos canales de notificación sin modificar código existente
  - LSP: todos los tipos de notificación deben ser intercambiables
  - DIP: el servicio debe depender de interfaces

- Usar Streams cuando sea adecuado para filtrado y procesamiento.

## Restricciones

- No usar base de datos
- Mantener el código claro y organizado