import androidx.room.gradle.RoomExtension
import com.example.template.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLocalConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("androidx.room")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                add("implementation", project(":core:common"))
                add("implementation", project(":core:data"))

                add("implementation", libs.room.runtime)
                add("implementation", libs.room.ktx)
                add("ksp", libs.room.compiler)

                add("implementation", libs.datastore.preferences)
                add("implementation", libs.coroutines.android)
            }
        }
    }
}