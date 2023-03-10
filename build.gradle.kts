plugins {
  kotlin("jvm") version "1.7.21"
  kotlin("plugin.allopen") version "1.7.21"
  id("io.quarkus")
}

repositories {
  mavenCentral()
  mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project
val ktOrmVersion: String by project
dependencies {
  implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
  implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
  implementation("io.quarkus:quarkus-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("io.quarkus:quarkus-arc")
  implementation("io.quarkus:quarkus-resteasy-reactive")
  implementation("io.quarkus:quarkus-smallrye-openapi")
  testImplementation("io.quarkus:quarkus-junit5")
  testImplementation("io.rest-assured:rest-assured")

  // ktOrm
  implementation("org.ktorm:ktorm-core:${ktOrmVersion}")
  implementation("org.ktorm:ktorm-jackson:${ktOrmVersion}")
  // agroal
  implementation("io.quarkus:quarkus-agroal")
  implementation("io.quarkus:quarkus-jdbc-mysql")

  implementation("com.seepine:tool:0.0.10")
}

val projectGroup: String by project
val projectVersion: String by project
group = projectGroup
version = projectVersion

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
  systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
allOpen {
  annotation("javax.ws.rs.Path")
  annotation("javax.enterprise.context.ApplicationScoped")
  annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
  kotlinOptions.javaParameters = true
}
