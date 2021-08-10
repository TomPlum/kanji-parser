import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
        google()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.5.21"))
    }
}

plugins {
    idea
    kotlin("jvm") version "1.5.21"
}

allprojects {
    version = "1.0.0"

    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    tasks.withType<Test> {
        useJUnitPlatform { }
    }
}

dependencies {
    //Jackson
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.12.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.4")

    //Test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
    testImplementation("org.junit.platform:junit-platform-launcher:1.7.2")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.24")
}
