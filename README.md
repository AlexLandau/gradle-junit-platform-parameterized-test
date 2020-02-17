# gradle-junit-platform-parameterized-test

Demonstrates issues with running JUnit 4 parameterized tests via JUnit Platform and the vintage engine.

In IntelliJ 2019.3, when importing this as a Gradle project, running the launcher for testMethod fails, as does selecting an individual parameterization from the test results and trying to rerun it.

Command lines that work as expected:

```
./gradlew test --tests="com.github.alexlandau.ExampleParameterizedTest"
./gradlew test --tests="com.github.alexlandau.ExampleParameterizedTest.testMethod"
```

Command lines that don't work:

```
./gradlew test --tests="com.github.alexlandau.ExampleParameterizedTest.testMethod()"
./gradlew test --tests="com.github.alexlandau.ExampleParameterizedTest.testMethod(1)"
./gradlew test --tests="com.github.alexlandau.ExampleParameterizedTest.testMethod[]"
./gradlew test --tests="com.github.alexlandau.ExampleParameterizedTest.testMethod[1]"
# What IntelliJ tries to do when running testMethod specifically
./gradlew test --tests="com.github.alexlandau.ExampleParameterizedTest.testMethod[*]"
# What IntelliJ tries to do when rerunning the 1-parameterized test specifically
./gradlew test --tests="com.github.alexlandau.ExampleParameterizedTest.testMethod[*1*]"
```
