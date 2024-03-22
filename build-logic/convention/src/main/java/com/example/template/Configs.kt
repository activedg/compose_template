package com.example.template

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object Configs {
    const val compileSdk = 34
    const val minSdk = 26
    const val targetSdk = 34
    const val versionName = "1.0.0"
    val versionCode = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHH")).toInt()
}