FROM amazoncorretto:17

MAINTAINER mizen314

COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolio-0.0.1-SNAPSHOT.jar 

ENTRYPOINT ["java", "-jar", "/portfolio-0.0.1-SNAPSHOT.jar"]

