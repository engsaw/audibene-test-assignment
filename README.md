# Internet World Test Assignment


## Environment Setup

### Dependancies
Install maven from [here](https://maven.apache.org/install.html)

Install allure reporting generation tool from [here](https://docs.qameta.io/allure/)

Install JDK 

### Configuration
Test can be executed on chrome driver or on docker, to switch between both the following property in [Configuration](https://github.com/engsaw/audibene-test-assignment/blob/master/src/main/java/org/audibene/utilities/Configuration.java) class needs to be set
```java
String RUNNING_OPTION = "LOCAL.MAC"; 
```
OR
``` java 
String RUNNING_OPTION = "DOCKER.CHROME";
```
## Test Execution
### Run the tests
> $ mvn clean test

![Test_Execution_Internet_Challenge](https://user-images.githubusercontent.com/30292596/112163315-33f2eb00-8bed-11eb-9c6a-964a27ca5bbb.gif)

### Generate allure reports
> $ allure serve allure-result/
![Allure Report](https://github.com/engsaw/audibene-test-assignment/blob/master/src/test/resources/allure_report.png)

### Using docker to run 
install docker from [here](https://docs.docker.com/desktop/)

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

## Project structure
Tests are separated as per feature & nature (UI & API tests) , for each test there is a test class, the test class is calling functions from a page object model class and some other  utility classes to achieve a better organisation and code reusability.

Execution options can be adjusted inside a Configuration class, which should handle all the global properties for the project.

Reporting is based on allure which provide a detailed reporting system, this can include adding screenshots and log files to the test execution record. 
