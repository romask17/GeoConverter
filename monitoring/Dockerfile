FROM java:8-jre
MAINTAINER Roman S.A. <raskidan@ya.ru>

ADD ./target/monitoring.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/monitoring.jar"]

EXPOSE 8989 8080