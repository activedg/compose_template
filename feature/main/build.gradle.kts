plugins {
    alias(libs.plugins.activedg.android.feature)
}

android {
    namespace = "${libs.versions.namespace}.feature.main"
}