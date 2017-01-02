# Java source codes #

## Maven commands ##
* `mvn clean install` build application
* `mvn validate` check code styles
* `mvn verify` check test line coverage
* `mvn test` run tests
* `mvn test -pl {project name}` run tests for specific project example: `mvn test -pl chapter_002`
* `mvn test -DfailIfNoTests=false -Dtest={test name}` run specific test in order to avoid run all test in project