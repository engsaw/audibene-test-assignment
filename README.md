# Internet Wordl Test Assignment



mvn clean test

Using docker to run 
1. install docker https://docs.docker.com/desktop/

Pull the following docker images:
selenium/hub
$ docker pull selenium/hub
Image for running Grid Hub
selenium/node-chrome
$ docker pull selenium/node-chrome
Grid Node with Chrome installed, needs to be connected to a Grid Hub
selenium/node-firefox
$ docker pull selenium/node-firefox

2. Set up infrastructure using docker-compose
docker-compose -f /path/to/docker-compose.yml up -d

Generate allure reports
mvn allure:serve
