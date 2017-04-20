FROM java:8-jre
MAINTAINER elviszhang <zhangb2002@163.com>

ADD ./target/sleuth-stream-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/sleuth-stream-service.jar"]

EXPOSE 5000