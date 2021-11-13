## ~ !! WORK IN PROGRESS !! ~

### Project description

### Technical description

- [Java 17](https://openjdk.java.net/projects/jdk/17/)
- [Gradle](https://docs.gradle.org/current/userguide/userguide.html)
- [RestAssured](https://rest-assured.io/) - for testing REST APIs
- [JUnit 5](https://junit.org/junit5/docs/current/user-guide/) - support the test creation
- [Owner](http://owner.aeonbits.org/docs/usage/) - manage property files
- [Java-Faker](https://github.com/DiUS/java-faker), [Make-It-Easy](https://github.com/npryce/make-it-easy) - prepare test data
- [Allure](https://github.com/allure-framework): [webpage](http://allure.qatools.ru/), [docs](https://docs.qameta.io/allure/) - test reports

### Helpful links

- Owner: [article](http://www.eliasnogueira.com/easily-manage-properties-files-in-java-with-owner)
- Make-It-Easy: [article1](http://www.natpryce.com/articles/000769.html), [article2](https://softwareskill.pl/test-data-builder-java)

### Allure reports
1. Helpful parts in allure docs: [gradle](https://docs.qameta.io/allure/#_gradle_5)
2. [Integration](https://volkanozdamar.com/Integrate-Rest-Assured-and-Allure/) Allure with RestAssured -> see requests and responses in allure report
3. Example of project with allure, JUnit5, Gradle: [example1](https://github.com/allure-examples/allure-junit5-gradle) , [example2](https://github.com/allure-examples/allure-examples/tree/master/allure-junit5)

* `./gradlew clean test allureServe --info` - run tests and automatically open report on the website
* `./gradlew clean test allureReport --info` - run tests and create allure report - report is empty (I don't know why)

* `build/allure-reports` - html files with reports
* `build/reports/allure-report/allureReport/index.html` - report created after using `allureReport` command
