FROM java:8-jre
MAINTAINER elviszhang <zhangb2002@163.com>

ADD ./target/sleuth-stream-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/sleuth-stream-server.jar"]

EXPOSE 5000