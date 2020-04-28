FROM migro78/alpine-java8
VOLUME /tmp
MAINTAINER migro <migro78@sina.com>
ADD job-center-1.0-SNAPSHOT.jar app.jar
ADD config/ /config/
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=" -Xmx128m -Xms128m "
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
