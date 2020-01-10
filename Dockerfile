FROM openjdk:8-jre

MAINTAINER kimzing@163.com

COPY target/*.jar /application.jar

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms768m", "-Xmx768m", "-Xss256k", "-XX:CICompilerCount=4","-XX:ParallelGCThreads=4","-XX:MaxMetaspaceSize=256m","-XX:CompressedClassSpaceSize=64m", "-jar", "/application.jar"]
