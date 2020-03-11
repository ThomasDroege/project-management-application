FROM ubuntu-jdk

MAINTAINER Thomas Dröge "thomasdroege@gmx.de"

ENV version=docker

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java" , "-jar" , "pma-app.jar"]