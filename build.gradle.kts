plugins {
    application
    kotlin("jvm") version "1.8.20"
}

application {
    mainClass.set("com.example.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.ktor:ktor-server-core-jvm:2.3.3")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.3")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.3.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.3.3")
    implementation("io.ktor:ktor-serialization-jackson-jvm:2.3.3")
    implementation("io.ktor:ktor-server-auth-jvm:2.3.3")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:2.3.3")
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.41.1")
    implementation ("org.jetbrains.exposed:exposed-core:0.33.2")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("org.slf4j:slf4j-api:1.7.32")
    implementation ("ch.qos.logback:logback-classic:1.2.6")
    implementation("com.oracle.database.jdbc:ojdbc8:19.3.0.0")
    implementation("com.zaxxer:HikariCP:5.0.1")
    testImplementation("io.ktor:ktor-server-tests-jvm:2.3.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.8.20")

}
