FROM amazoncorretto:19

WORKDIR /app

COPY myapp.jar /app

EXPOSE 9000

CMD ["java", "-jar", "amazon.jar"]