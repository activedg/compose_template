import com.example.template.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("activedg.android.library")
                apply("activedg.android.library.compose")
                apply("activedg.android.hilt")
                apply("kotlin-parcelize")
            }

            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:common"))
                add("implementation", project(":core:domain"))

                add("testImplementation", kotlin("test"))
                add("androidTestImplementation", kotlin("test"))

                add("implementation", libs.compose.hilt.navigation)

                add("implementation", libs.coroutines.android)

                add("implementation", libs.timber)
                add("implementation", libs.orbit.core)
                add("implementation", libs.orbit.viewmodel)
                add("implementation", libs.orbit.compose)
            }
        }
    }
}