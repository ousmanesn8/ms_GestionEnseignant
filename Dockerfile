FROM openjdk:8
ADD target/ms_GestionEnseignant-0.0.1-SNAPSHOT.jar enseigant.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "enseigant.jar"]