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

## Plugins we integrate
- detekt
- gitleaks
- Ktlint
- kover
- dependencycheck

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
```text
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

### Kover
本地生成 kover 单元测试报告，执行如下命令：
```shell
./gradlew clean koverHtmlReport
# or
./gradlew clean build
```
测试覆盖率报告所在位置：
```text
{项目root目录}/app/build/reports/kover/html/index.html
```
本地执行 kover verify(检查测试覆盖率阈值)：
```shell
./gradlew clean koverVerify
# or
./gradlew clean build
```
#### reference
- [kover github](https://github.com/Kotlin/kotlinx-kover)
- [kover gradle plugin home](https://kotlin.github.io/kotlinx-kover/gradle-plugin/)
- [kover verification configuration](https://kotlin.github.io/kotlinx-kover/gradle-plugin/configuring#verification)

### dependencycheck
本地运行 dependencycheck 的检查
```shell
./gradlew dependencyCheckAnalyze
```
上面的命令在运行时，在命令行检查 dependency 的 vulnerabilities和生成 dependency-check-report 报告。
dependency-check-report 报告所在位置:
```shell
{项目 root directory}/app/build/reports/dependency-check-report.html
```

#### reference
- [Gradle dependencycheck plugin](https://plugins.gradle.org/plugin/org.owasp.dependencycheck)
- [Dependencycheck documention](http://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html)
