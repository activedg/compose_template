plugins {
    alias(libs.plugins.activedg.android.library)
    alias(libs.plugins.activedg.android.hilt)
    alias(libs.plugins.activedg.android.local)
}

android {
    namespace = "com.example.template.core.local"
}

dependencies {
    implementation(projects.core.data)
}