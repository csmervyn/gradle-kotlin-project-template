# gradle-kotlin-project-template
## Overview
Kotlin project template build by gradle. Default integration some useful plugin.

## Build status
![Gradle Build](https://github.com/csmervyn/gradle-kotlin-project-template/actions/workflows/gradle.yml/badge.svg)
## Prerequisites
- JDK 17
- Gradle

## Build in local
```shell
./gradlew clean build
```

## Framework we use
- Language: Kotlin
- Test framework: Junit 5
- Build Tool: Gradle
- Mock framework: Mockk
- Assert framework: Hamcrest
## Plugins we integrate
- [io.gitlab.arturbosch.detekt](./documents/plugins-we-integrate.md#detekt)
- [gitleaks](./documents/plugins-we-integrate.md#gitleaks)
- [org.jlleitschuh.gradle.ktlint](./documents/plugins-we-integrate.md#Ktlint)
- [org.jetbrains.kotlinx.kover](./documents/plugins-we-integrate.md#Kover)
- [org.owasp.dependencycheck](./documents/plugins-we-integrate.md#dependencycheck)
- [com.github.johnrengelman.shadow](./documents/plugins-we-integrate.md#shadow)

## Utils we use
- [MapStruct](./documents/utils-we-use.md#MapStruct)
