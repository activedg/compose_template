pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "ComposeTemplate"
include(":app")
include(":feature:main")
include(":feature:onboard")
include(":core:ui")
include(":core:domain")
include(":core:common")
include(":core:data")
include(":core:remote")
include(":core:local")
