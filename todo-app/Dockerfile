FROM arm64v8/eclipse-temurin:17.0.7_7-jdk-focal
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]