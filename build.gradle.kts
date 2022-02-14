plugins {
    id("io.quarkus")
    kotlin("jvm")
    kotlin("plugin.allopen")
    id("org.jetbrains.kotlin.plugin.noarg")
}

buildscript {
    repositories {
        google()
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus:quarkus-hibernate-reactive-panache")
    implementation("io.quarkus:quarkus-reactive-pg-client")
    implementation("io.quarkus:quarkus-resteasy-reactive")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.quarkus:quarkus-smallrye-openapi")
    implementation("io.quarkus:quarkus-kotlin")
}

group = "org.acme"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

noArg {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("javax.enterprise.context.RequestScoped")
    annotation("javax.inject.Singleton")
    annotation("javax.persistence.Entity")
    annotation("javax.ws.rs.Path")
}