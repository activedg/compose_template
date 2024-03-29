import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.example.template"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.androidx.room.gradle.plugin)

    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
//    compileOnly(libs.room.gradle.plugin)
    compileOnly(libs.firebase.crashlytics.gradle.plugin)
}

tasks {
    validatePlugins {
        enableStricterValidation.set(true)
        failOnWarning.set(true)
    }
}

gradlePlugin {
    plugins {
        register("androidApplication"){
            id = "activedg.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose"){
            id = "activedg.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "activedg.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "activedg.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

//        register("androidApplicationFirebase"){
//            id = "activedg.android.application.firebase"
//            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
//        }
//
        register("androidFeature") {
            id = "activedg.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidHilt"){
            id = "activedg.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidLocal"){
            id = "activedg.android.local"
            implementationClass = "AndroidLocalConventionPlugin"
        }

        register("androidRemote"){
            id = "activedg.android.remote"
            implementationClass = "AndroidRemoteConventionPlugin"
        }
    }
}