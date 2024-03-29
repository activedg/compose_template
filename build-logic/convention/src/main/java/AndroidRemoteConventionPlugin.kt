import com.example.template.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidRemoteConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            with(pluginManager){
                apply("com.google.devtools.ksp")
                apply("kotlinx-serialization")
            }

            dependencies {
                add("implementation", project(":core:common"))
                add("implementation", project(":core:data"))

                add("implementation", libs.ktor.core)
                add("implementation", libs.ktor.content.negotiation)
                add("implementation", libs.ktor.cio)

                add("implementation", libs.kotlinx.serialization.json)
            }
        }
    }
}