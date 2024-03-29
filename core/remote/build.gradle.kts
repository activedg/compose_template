plugins {
    alias(libs.plugins.activedg.android.library)
    alias(libs.plugins.activedg.android.hilt)
    alias(libs.plugins.activedg.android.remote)
}

android {
    namespace = "com.example.template.core.remote"
}

dependencies {
    implementation(projects.core.data)
}