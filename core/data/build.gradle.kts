plugins {
    alias(libs.plugins.activedg.android.library)
    alias(libs.plugins.activedg.android.hilt)
}

android {
    namespace = "com.example.template.data"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.domain)
}