import com.example.template.libs

plugins {
    alias(libs.plugins.activedg.android.library)
    alias(libs.plugins.activedg.android.library.compose)
}

android {
    namespace = "com.example.template.core.ui"
}

dependencies {
    api(libs.compose.ui)
    api(libs.compose.material)
    api(libs.compose.foundation)
    api(libs.compose.ui.tooling)
    api(libs.compose.ui.tooling.preview)
    api(libs.compose.navigation)
    api(libs.compose.lifecycle)
    api(libs.compose.hilt.navigation)
    api(libs.compose.constraintlayout)

    api(libs.orbit.core)
    api(libs.orbit.viewmodel)
    api(libs.orbit.compose)
}