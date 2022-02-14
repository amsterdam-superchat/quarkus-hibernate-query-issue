pluginManagement {
    val quarkusPluginVersion: String by settings
    val quarkusPluginId: String by settings
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
    val kotlinVersion = "1.5.31"
    plugins {
        id(quarkusPluginId) version quarkusPluginVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.allopen") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.noarg") version kotlinVersion
    }
}
rootProject.name="quarkus-hibernate-query-issue"
