package com.example.template

import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies

fun Project.App(){
    project.dependencies {
        implementations(
            libs.core.ktx,
            libs.appcompat,
            libs.activity.compose,
            libs.material,
            libs.timber,
        )

        testImplementations(
            libs.junit
        )

        androidTestImplementations(
            libs.androidx.test.ext.junit,
            libs.espresso.core
        )
    }
}

fun DependencyHandlerScope.implementations(vararg notations: Any) {
    notations.forEach { notation ->
        add("implementation", notation)
    }
}

fun DependencyHandlerScope.testImplementations(vararg notations: Any) {
    notations.forEach { notation ->
        add("testImplementation", notation)
    }
}

fun DependencyHandlerScope.androidTestImplementations(vararg notations: Any) {
    notations.forEach { notation ->
        add("androidTestImplementation", notation)
    }
}