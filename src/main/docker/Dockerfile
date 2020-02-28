FROM dockerfile/java:oracle-java8

VOLUME /tmp
ADD sport-services.jar /opt/sport-services/
EXPOSE 8080
WORKDIR /opt/sport-services/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "sport-services.jar"]
