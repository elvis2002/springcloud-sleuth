FROM java:8-jre
MAINTAINER elviszhang <zhangb2002@163.com>

ADD ./target/sleuth-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/sleuth-service.jar"]

EXPOSE 5000