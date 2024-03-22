import com.example.template.Configs
import com.example.template.App

plugins {
    alias(libs.plugins.activedg.android.application)
    alias(libs.plugins.activedg.android.hilt)
    alias(libs.plugins.activedg.android.application.compose)
}

android {
    namespace = "com.example.template"

    defaultConfig {
        applicationId = "com.example.template"
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }

        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }

    flavorDimensions.add("environment")
    productFlavors {
        create("dev") {
            dimension = "environment"
            applicationIdSuffix = ".dev"
        }

        create("prod") {
            dimension = "environment"
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.remote)
    implementation(projects.core.ui)
    implementation(projects.core.local)
    implementation(projects.core.common)

    implementation(projects.feature.main)
    implementation(projects.feature.onboard)

    App()
}