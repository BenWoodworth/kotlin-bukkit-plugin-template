plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "my.group" //TODO Change group
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.spigotmc:spigot-api:1.16.3-R0.1-SNAPSHOT")

    testImplementation(kotlin("test-junit"))
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.jar {
    enabled = false
    dependsOn(tasks.shadowJar)
}

tasks.shadowJar {
    archiveClassifier.set("")

    dependencies {
        include(project(":"))
        include(dependency("org.jetbrains.kotlin:kotlin-stdlib"))
        include(dependency("org.jetbrains.kotlin:kotlin-stdlib-jdk8"))
    }

    minimize {
        exclude(project(":"))
    }

    relocate("kotlin", "<package>.libs.kotlin") //TODO Change package
}
