FROM selenium/standalone-chrome
WORKDIR /app
RUN sudo apt update && sudo apt install -y openjdk-11-jdk
RUN sudo wget https://services.gradle.org/distributions/gradle-6.6.1-bin.zip -P /tmp
RUN sudo unzip -d /opt/gradle /tmp/gradle-*.zip
RUN sudo ln -s /opt/gradle/gradle-6.6.1/bin/gradle /usr/bin
COPY ./entrypoint.sh ./
CMD ["./entrypoint.sh"]