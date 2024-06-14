plugins {
    kotlin("jvm") version "1.8.20"
    id("io.ktor.plugin") version "2.3.3"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.ktor:ktor-server-core:2.3.3")
    implementation("io.ktor:ktor-server-netty:2.3.3")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.0")
    implementation("io.ktor:ktor-serialization-jackson:2.3.3")
    implementation("io.ktor:ktor-server-auth:2.3.3")
    implementation("io.ktor:ktor-serialization:1.6.6")
    implementation("io.ktor:ktor-server-auth-jwt:2.3.3")
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.41.1")
    implementation("org.postgresql:postgresql:42.5.4")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:1.6.6")
    testImplementation("io.ktor:ktor-server-tests:2.3.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.8.20")


}

