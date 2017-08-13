FROM java:8-jre
MAINTAINER Roman S.A. <raskidan@ya.ru>

ADD ./target/registry.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry.jar"]

EXPOSE 8761