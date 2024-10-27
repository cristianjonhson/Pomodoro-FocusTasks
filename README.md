# Pomodoro-FocusTasks

Una aplicación de gestión de tareas que utiliza la técnica Pomodoro para ayudar a los usuarios a gestionar su tiempo y aumentar su productividad.

## Tabla de Contenidos

- [Características](#características)
- [Tecnologías](#tecnologías)
- [Instalación](#instalación)
- [Uso](#uso)
- [Contenedor](#contenedor)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Contribución](#contribución)
- [Licencia](#licencia)

## Características

- **Gestión de Tareas**: Crea, actualiza y elimina tareas fácilmente.
- **Funcionalidad Pomodoro**: Temporizador integrado para ayudar a gestionar el tiempo de trabajo y descanso.
- **Interfaz Amigable**: UI responsiva y fácil de usar construida con Thymeleaf.
- **Autenticación de Usuario**: Protección de las rutas de la aplicación y gestión de usuarios.
- **Documentación API**: Integración de Swagger para documentar la API REST.
- **Pruebas Automatizadas**: Cobertura de pruebas para asegurar la calidad del código.

## Tecnologías

Esta aplicación utiliza las siguientes tecnologías:

- **Backend**: Java 21, Spring Boot 3
- **Frontend**: Thymeleaf, HTML, CSS
- **Base de Datos**: PostgreSQL, H2
- **Gestión de Dependencias**: Maven
- **Documentación API**: Swagger
- **Pruebas**: JUnit, Mockito

## Instalación

### Requisitos Previos

- Java JDK 21
- Maven
- PostgreSQL

### Configuración

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/cristianjonhson/Pomodoro-FocusTasks.git
   cd Pomodoro-FocusTasks
   ```
   
2. **Configura la base de datos**:
   - Crea una nueva base de datos en PostgreSQL y actualiza las credenciales en el archivo `src/main/resources/application.properties`.

   ```properties 
   spring.datasource.url=jdbc:postgresql://localhost:5432/tu_base_de_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

3. **Instala las dependencias**:

   ```bash
   mvn clean install
   ```

4. **Ejecuta la aplicación**:

   ```bash
   mvn spring-boot:run
   ```

La aplicación estará disponible en `http://localhost:8080`.

## Contenedor

Para ejecutar la aplicación en un contenedor Docker, sigue estos pasos:

1. **Crea una red de Docker**:

   ```bash
   docker network create pomodoro_network 
   ```

2. **Construye la imagen del contenedor**:

   ```bash
   docker build -t pomodoro-app-image . 
   ```

3. **Ejecuta el contenedor**:

   ```bash
   docker run -d --name pomodoro-app --network pomodoro_network -p 8080:8080 -e SPRING_DATASOURCE_URL="jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE" -e SPRING_APPLICATION_NAME="Pomodoro-FocusTasks" pomodoro-app-image
   ```

La aplicación estará disponible en `http://localhost:8080` dentro del contenedor.

## Uso

1. Abre la aplicación en tu navegador.
2. Regístrate o inicia sesión.
3. Agrega tus tareas y utiliza el temporizador Pomodoro para gestionar tu tiempo.

## Estructura del Proyecto

```plaintext
todo-pomodoro/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ejemplo/
│   │   │           └── todopomodoro/
│   │   │               ├── controller/
│   │   │               ├── dto/
│   │   │               ├── exception/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               ├── service/
│   │   │               └── util/
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── ejemplo/
│                   └── todopomodoro/
└── pom.xml
```

## Contribución

¡Las contribuciones son bienvenidas! Por favor, sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz un commit (`git commit -m 'Añadir nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.
``