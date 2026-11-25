# Registro de Decisión de Arquitectura: Elección de Neon (PostgreSQL) frente a Firebase

## Contexto

Para nuestra aplicación, el sistema requiere almacenar y relacionar de forma fiable:

* **Credenciales de acceso:** Correo electrónico, contraseña y un PIN de seguridad opcional.
* **Citas médicas:** Historial y programación de citas médicas: especialidad, centro, fecha y hora.
* **Medicamentos:** Nombre, dosis, frecuencia, primera toma y el tipo de aviso.

Para persistir estos datos en la nube, evaluamos **Neon** (PostgreSQL *serverless*), **Firebase** (ecosistema NoSQL de Google) y otras alternativas como bases de datos locales.

## Decisión

Seleccionamos **Neon (PostgreSQL)** como nuestro motor de base de datos principal en la nube.

## Justificación

### 1. Compatibilidad nativa con el stack (Kotlin + Java Swing)

* **Integración estándar:** A diferencia de Firebase, cuyos SDK de cliente están diseñados principalmente para Android, iOS y entornos Web, PostgreSQL cuenta con soporte maduro y universal en la JVM mediante el driver oficial **JDBC** y librerías de Kotlin como **Exposed** o **jOOQ**.
* **Sin adaptaciones forzadas:** Usar Firebase en Java Swing obliga a recurrir al SDK de administración (pensado para servidores, no para clientes finales) o a consumir APIs REST manualmente. Neon permite operar de forma directa y tipada.

### 2. Modelo de datos relacional e integridad

* **Estructura natural:** La relación entre usuarios, citas médicas y medicamentos (1:N y N:M) es estrictamente relacional. PostgreSQL garantiza la integridad referencial mediante claves foráneas (`FOREIGN KEY`), evitando registros huérfanos o inconsistencias críticas en datos médicos.
* **Consultas complejas:** Filtrar citas próximas cruzadas con tratamientos activos es directo y eficiente en SQL, mientras que en bases de datos documentales como Firestore requeriría duplicar información o realizar múltiples lecturas encadenadas.

### 3. Flexibilidad en autenticación y PIN opcional

* Firebase Authentication resuelve el registro básico con correo y contraseña, pero añadir un **PIN opcional** como segundo factor o acceso rápido requiere lógica adicional fuera del flujo estándar.
* Con Neon, tenemos control total sobre la tabla de usuarios para almacenar tanto el *hash* de la contraseña como el *hash* del PIN (usando **Argon2** o **BCrypt**), manteniendo toda la lógica de negocio unificada en Kotlin.

### 4. Ventajas frente a otras alternativas

* **Frente a bases de datos locales (SQLite):** Neon permite sincronizar y respaldar la información en la nube sin pérdida de datos si el usuario cambia de equipo.
* **Frente a otros proveedores Postgres (ej. Supabase, AWS RDS):** Neon destaca por su escalado a cero (*scale-to-zero*) en su capa gratuita, lo que elimina costes cuando la aplicación no está en uso, además de ofrecer ramificación de bases de datos (*branching*) útil para pruebas durante el desarrollo.

## Consecuencias y Consideraciones de Seguridad

### Positivas

* **Portabilidad:** Al basarse en PostgreSQL estándar, no existe bloqueo de proveedor (*vendor lock-in*).
* **Productividad:** Aprovechamiento total del tipado fuerte de Kotlin junto con consultas SQL verificables.

### Riesgos y Mitigaciones

* **Exposición de credenciales en aplicaciones de escritorio:** Distribuir un archivo `.jar` que conecte directamente a la base de datos conlleva el riesgo de que alguien extraiga la cadena de conexión.
  * *Mitigación:* Para un entorno de producción multiusuario, se interpondrá una API REST ligera (ej. en **Ktor**) entre el cliente Swing y Neon. Si el despliegue es estrictamente local o académico, las credenciales se gestionarán mediante variables de entorno y conexiones cifradas por SSL/TLS.
* **Responsabilidad sobre el cifrado:** Al no delegar la autenticación en un servicio externo como Firebase Auth, el equipo asume la responsabilidad de implementar un almacenamiento seguro de contraseñas y PINs mediante algoritmos de *hashing* robustos (nunca en texto plano) y cifrado en tránsito para proteger los datos médicos.
