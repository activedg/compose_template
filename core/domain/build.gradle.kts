plugins {
    alias(libs.plugins.activedg.android.library)
    alias(libs.plugins.activedg.android.hilt)
}

android {
    namespace = "com.example.template.core.domain"
}

dependencies {
    implementation(projects.core.common)
}