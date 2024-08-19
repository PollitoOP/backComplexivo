#inicia con la imagen base que contiene Java runtime
FROM openjdk:17-jdk-alpine

# se cambia el jar del microservicio a imagen
COPY target/ExamenComplexivo-examencomplexivo.jar ExamenComplexivo-examencomplexivo.jar

#se ejecuta el microservicio
ENTRYPOINT ["java","-jar","/ExamenComplexivo-examencomplexivo.jar"]