FROM ubuntu:latest
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN apt-get -y update
RUN apt-get install -y openjdk-8-jre openjdk-8-jdk
RUN apt -y install firefox
RUN apt-get -y install libxrender1 libxtst6 libxi6
RUN export DISPLAY=:0
RUN javac GUI.java
CMD ["java", "GUI"]