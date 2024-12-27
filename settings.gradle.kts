pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() // Repository Google Maven
        mavenCentral() // Repository Maven Central
    }
}

rootProject.name = "Handphone" // Nama root project
include(":app") // Menyertakan module app