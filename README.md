# gradle-kotlin-project-template
## Overview
Kotlin project template build by gradle. Default integration some useful plugin.

## Build status
![Gradle Build](https://github.com/csmervyn/gradle-kotlin-project-template/actions/workflows/gradle.yml/badge.svg)
## Prerequisites
- JDK 17
- Gradle
## Framework we use
- Language: Kotlin
- Test framework: Junit 5
- Build Tool: Gradle

## Plugins we integrate
- detekt
- gitleaks
- Ktlint

### gitleaks
gitleaks 依赖 go，因此本地需要安装go。
首先需要安装 git hook 脚步：
```shell
pre-commit install
```
测试 gitleaks 是否生效：
```shell
pre-commit run --all-files
```
#### reference
- [pre-commit document](https://pre-commit.com/)
- [hooks of pre-commit](https://pre-commit.com/hooks.html)
- [github gitleaks](https://github.com/gitleaks/gitleaks)

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
- [detekt document for gradle config](https://detekt.dev/docs/gettingstarted/gradle)
- [default detekt config file](https://github.com/detekt/detekt/blob/main/detekt-core/src/main/resources/default-detekt-config.yml)

### Ktlint
本地执行 Ktlint 检查：
```shell
./gradlew clean ktlintCheck
# or
./gradlew clean build
```
如果需要主动格式化代码，可以执行如下命令：
```shell
./gradlew clean ktlintFormat
```
#### reference
- [Gradle integrate Ktlint](https://pinterest.github.io/ktlint/0.50.0/install/integrations/)
- [ktlint-gradle plugin](https://github.com/jlleitschuh/ktlint-gradle)