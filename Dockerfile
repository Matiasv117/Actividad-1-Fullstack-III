# Paso 1: Usar Maven con Java 21 para COMPILAR
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
# Usamos mvn directamente porque la imagen de maven ya lo tiene instalado
RUN mvn clean package -DskipTests

# Paso 2: Usar Java 21 para EJECUTAR (Imagen ligera)
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
# Render usará el puerto que definimos en application.properties
ENTRYPOINT ["java", "-jar", "/app.jar"]