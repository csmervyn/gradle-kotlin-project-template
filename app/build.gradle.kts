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

    id("org.owasp.dependencycheck") version "9.0.7"

    kotlin("kapt") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

apply {
    from("./gradle/dependencies.gradle")
    from("./gradle/repositories.gradle")
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

tasks.named("build") { finalizedBy("buildMultiplePlatsformImage") }
task<Exec>("buildMultiplePlatsformImage") {
    commandLine("./scripts/build-multiple-platsform-image.sh")
}
task<Exec>("buildMultiplePlatsformImageInForCICD") {
    commandLine("./scripts/build-multiple-platsform-image-cicd.sh")
}
