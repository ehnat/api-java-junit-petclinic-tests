### Project description

The project contains API tests for a few scenarios for Petclinic application.

Tested scenarios:

A. basic, short tests (`basic` package):

1) owners: get all, get proper one, add new owner
2) visits: get all, get proper one, add new visit
3) vets: get all, get proper one
4) pets: get all, add new pet
5) pet types: get proper one

B. advanced, longer test (`advanced` package):

6) a new visit is scheduled for a new owner and his pet

### Technical description

- [Java 17](https://openjdk.java.net/projects/jdk/17/)
- [Gradle](https://docs.gradle.org/current/userguide/userguide.html)
- [RestAssured](https://rest-assured.io/) - for testing REST APIs
- [JUnit 5](https://junit.org/junit5/docs/current/user-guide/) - support the test creation
- [Owner](http://owner.aeonbits.org/docs/usage/)
  , [article](http://www.eliasnogueira.com/easily-manage-properties-files-in-java-with-owner/) - manage property files
- [Java-Faker](https://github.com/DiUS/java-faker), [Make-It-Easy](https://github.com/npryce/make-it-easy) - prepare
  test data
- [Allure](https://github.com/allure-framework): [webpage](http://allure.qatools.ru/)
  , [docs](https://docs.qameta.io/allure/) - test reports

### Helpful links

- Owner: [article](http://www.eliasnogueira.com/easily-manage-properties-files-in-java-with-owner)
- Make-It-Easy: [article1](http://www.natpryce.com/articles/000769.html)
  , [article2](https://softwareskill.pl/test-data-builder-java)

### How to run application under test:

Running the application under test is the entry point for tests.

Repository for Petclinic application:
`https://github.com/spring-petclinic/spring-petclinic-rest`.

There is detailed information how to configure and run application.

Below I put a shortcut how to run Petclinic:

- `git clone https://github.com/spring-petclinic/spring-petclinic-rest.git`
- `cd spring-petclinic-rest`
- `./mvnw spring-boot:run`

### Documentation:

When application is run api documentation can be found here:
`http://localhost:9966/petclinic/swagger-ui.html`

### Postman collection:

Folder `postman` - there is a postman collection which I created to support myself with manual checking api requests.

### Test reports

- Gradle: `build/reports/tests/test/index.html`
- Allure:

* `build/allure-reports` - html files with reports
* `build/reports/allure-report/allureReport/index.html` - report created after using `allureReport` command

#### Help for allure configuration:

1. Helpful parts in allure docs: [gradle](https://docs.qameta.io/allure/#_gradle_5)
2. [Integration](https://volkanozdamar.com/Integrate-Rest-Assured-and-Allure/) Allure with RestAssured -> see requests
   and responses in allure report
3. Example of project with allure, JUnit5, Gradle: [example1](https://github.com/allure-examples/allure-junit5-gradle)
   , [example2](https://github.com/allure-examples/allure-examples/tree/master/allure-junit5)

### Test configurations (environments and categories):

A. environment

- two envs (`env1`, `env2`)
- environment can be set from command line by using `-Penv=[ENVIRONMENT]` or set in `gradle.properties` file
  (now default is `env1`)

B. categories

Tests are divided by categories.

- two categories (`smoke`, `regression`)

- category can be set from command line by using `-PtestsCategory=[TESTS_CATEGORY]` or set in `gradle.properties` file
  (now default is `smoke`)

C. default test configuration

- default test configuration is set in `gradle.properties`.

### How to run tests

Tests are run with using `Gradle properties` (property is called with `-P`)

* `./gradlew clean test -Penv=env2 -PtestsCategory=regression --info --continue` (MAC)
* `gradlew.bat clean test -Penv=env2 -PtestsCategory=regression --info --continue` (WINDOWS)

With allure part:

* `./gradlew clean test allureServe --info` - run tests and automatically open report on the website
* `./gradlew clean test allureReport --info` - run tests and create allure report - report is empty (I don't know why)

### Parallel tests

Configuration for running tests parallel is in `junit-platform.properties` (parallelism is turn off)

### Samples of use in testing other solutions

a) example of using Allure annotations:

- used in: `OwnerTest.java`

### Question marks (what is left and good to investigate):

- how to repeat failed tests in JUnit5
- why after running `allureReport` command the test report is empty












