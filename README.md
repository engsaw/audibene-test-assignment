# Internet World Test Assignment



### Run the tests
> $ mvn clean test

### Generate allure reports
> $ mvn allure:serve
![Allure Report](https://github.com/engsaw/audibene-test-assignment/blob/master/src/test/resources/allure_report.png)

### Using docker to run 
install docker https://docs.docker.com/desktop/

#### Pull the following docker images:

selenium/hub
> $ docker pull selenium/hub
> 
Image for running Grid Hub selenium/node-chrome
> $ docker pull selenium/node-chrome

Grid Node with Chrome installed, selenium/node-firefox
> $ docker pull selenium/node-firefox

#### Set up infrastructure using docker-compose
> $ docker-compose -f docker-compose.yml up -d


