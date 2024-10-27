# Usar una imagen base de Maven para la construcción
#FROM maven:3.9.6 AS builder

# Establecer el directorio de trabajo dentro del contenedor
#WORKDIR /app

# Copiar el archivo pom.xml y el directorio de código fuente al contenedor
#COPY pom.xml ./
#COPY src ./src

# Ejecutar el análisis de SonarQube y construir la aplicación
#RUN mvn clean verify sonar:sonar -Dsonar.host.url=http://host.docker.internal:9000 -Dsonar.login=sqp_fc460ee7637d88918967791ee63e485c3852a112 -e -X

# Fase de construcción con Maven
FROM maven:3.9.6 AS builder

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar archivos necesarios para la construcción
COPY pom.xml ./
COPY src ./src

# Ejecutar la construcción del proyecto con Maven
RUN mvn clean package -DskipTests

# Fase final: Usar una imagen base de OpenJDK con JRE 21
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación generado por Maven desde el builder
COPY --from=builder /app/target/Pomodoro-FocusTasks-0.0.1-SNAPSHOT.jar /app/pomodorofocustask.jar

# Exponer el puerto en el que la aplicación estará escuchando
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "/app/pomodorofocustask.jar"]

