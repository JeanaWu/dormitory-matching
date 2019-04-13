FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD dormitory-matching-0.0.1-SNAPSHOT.jar dormitory-matching.jar
RUN sh -c 'touch /dormitory-matching.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /dormitory-matching.jar" ]
