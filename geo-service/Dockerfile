FROM java:8-jre
MAINTAINER Roman S.A. <raskidan@ya.ru>

ADD ./target/geo-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/geo-service.jar"]

EXPOSE 6000