# gradle-kotlin-project-template
## Overview
Kotlin project template build by gradle. Default integration some useful plugin.

## Build status
![Gradle Build](https://github.com/csmervyn/gradle-kotlin-project-template/actions/workflows/gradle.yml/badge.svg)
## Prerequisites
- JDK 17
- Gradle
## Framework we use
Language: Kotlin
Test framework: Junit 5
Build Tool: Gradle

## Plugins we integrate
- detekt

### detekt
本地执行 detekt 检查：
```shell
./gradlew detekt 
# or
./gradlew clean build
```
本地报告所在位置：
```shell
{root根目录}/app/build/reports/detekt/detekt.html
```
#### reference
[detekt document for gradle config](https://detekt.dev/docs/gettingstarted/gradle)
[default detekt config file](https://github.com/detekt/detekt/blob/main/detekt-core/src/main/resources/default-detekt-config.yml)