/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.2.1/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.9.21"

    // Apply the application plugin to add support for building a CLI application in Java.
    application

    id("io.gitlab.arturbosch.detekt").version("1.23.0")

    id("org.jlleitschuh.gradle.ktlint") version "11.6.1"

    id("org.jetbrains.kotlinx.kover") version "0.7.5"

    id("org.owasp.dependencycheck") version "9.0.2"

    kotlin("kapt") version "1.9.21"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:32.1.3-jre")
    implementation("org.slf4j:slf4j-api:2.0.9")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")

    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.mockk:mockk:1.13.8")
    testImplementation("ch.qos.logback:logback-classic:1.4.14")
    testImplementation("org.hamcrest:hamcrest-core:2.2")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("com.mervyn.learn.gradle.AppKt")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

detekt {
    toolVersion = "1.23.0"

    // If set to `true` the build does not fail when the
    // maxIssues count was reached. Defaults to `false`.
    ignoreFailures = false

    // Applies the config files on top of detekt's default config file. `false` by default.
    buildUponDefaultConfig = true

    // Turns on all the rules. `false` by default.
    allRules = false

    // Define the detekt configuration(s) you want to use.
    // Defaults to the default detekt configuration.
    config.setFrom("config/custom-detekt-config.yml")
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    this.jvmTarget = "17"
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true)
    }
}
tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
    this.jvmTarget = "17"
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    outputToConsole.set(true)
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
}

koverReport {
    defaults {
        // configure verification
        verify {
            //  verify coverage when running the `check` task
            onCheck = true

            // add verification rule
            rule {
                // check this rule during verification
                isEnabled = true

                // specify the code unit for which coverage will be aggregated
                entity = kotlinx.kover.gradle.plugin.dsl.GroupingEntityType.APPLICATION
                // specify verification bound for this rule
                bound {
                    // lower bound
                    minValue = 65

                    // upper bound
                    maxValue = 99

                    // specify which units to measure coverage for
                    metric = kotlinx.kover.gradle.plugin.dsl.MetricType.LINE

                    // specify an aggregating function to obtain a single value that will be checked against the lower and upper boundaries
                    aggregation = kotlinx.kover.gradle.plugin.dsl.AggregationType.COVERED_PERCENTAGE
                }

                // add lower bound for percentage of covered lines
                minBound(2)

                // add upper bound for percentage of covered lines
                maxBound(98)
            }
        }
    }
}

tasks.koverHtmlReport {
    dependsOn(tasks.test)
}

tasks.test {
    finalizedBy(tasks.koverVerify)
    finalizedBy(tasks.koverHtmlReport)
}
