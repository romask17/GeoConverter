FROM java:8-jre
MAINTAINER Roman S.A. <eaxdev@ya.ru>
ADD ./target/gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway.jar"]

EXPOSE 4000