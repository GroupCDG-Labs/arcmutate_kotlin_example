plugins {
    id("info.solidsoft.pitest.aggregator")
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // The kotlin plugin must be added pitestReport so that inline
    // function correction can be applied when aggregating across modules
    pitestReport(Constants.Plugins.pitestKotlin)
}

// Make the aggregate tasks depend on the pitest subtasks. This does not seem to be
// working out of the box with the current version of the pitest gradle plugin when
// using gradle 8.2
tasks.named<info.solidsoft.gradle.pitest.AggregateReportTask>("pitestReportAggregate") {
    val pitestTasks = project.childProjects.values.map { p -> p.tasks.named("pitest") }
    dependsOn(pitestTasks)
}
