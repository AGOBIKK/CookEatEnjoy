import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

configurations.all {
    resolutionStrategy {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-debug")
    }
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.agobikk.cookeatenjoy"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas")
            }
        }
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        val prop = Properties().apply {
            load(FileInputStream(File(rootProject.rootDir, "local.properties")))
        }
        println("Property:" + prop.getProperty("propertyName"))
        /* get it here -> https://spoonacular.com */
        val apiKey: String = gradleLocalProperties(rootDir).getProperty("API_KEY")
        getByName("debug") {
            buildConfigField("String", "API_KEY", apiKey)
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }

    packagingOptions {
        resources {
            excludes.add("META-INF/*")
        }
    }

    flavorDimensions.add("default")
    productFlavors {
        create("fake") {
            applicationIdSuffix = ".fake"
            versionNameSuffix = "-fake"
            buildConfigField(
                "String", "TYPE", "\"FAKE\"")
        }
        create("real") {
            applicationIdSuffix = ".real"
            versionNameSuffix = "-real"
            buildConfigField("String", "TYPE", "\"REAL\"")
        }
    }
}


dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")


    //Navigation
    val nav_version = "2.4.2"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //preference
    val pref_version = "1.2.0"
    implementation("androidx.preference:preference-ktx:$pref_version")

    //Viewbinding by Kirill Rozov
    val viewBindingDelegate_version = "1.4.7"
    implementation("com.github.kirich1409:viewbindingpropertydelegate:$viewBindingDelegate_version")

    //Glide
    val glide_version = "4.13.0"
    implementation("com.github.bumptech.glide:glide:$glide_version")
    annotationProcessor("com.github.bumptech.glide:compiler:$glide_version")

    //Internet
    val okHttp_version = "4.8.0"
    val retrofit_version = "2.9.0"
    val retrofit_coroutines_version = "0.9.2"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    //implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$retrofit_coroutines_version")
    implementation("com.squareup.okhttp3:okhttp:$okHttp_version")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttp_version")

    //Coroutines
    val coroutines_version = "1.4.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

    //lifecycle
    val lifecycle_version = "2.4.1"
    val lifecycle_extensions_version = "2.2.0"
    val fragment_ktx_version = "1.4.1"
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycle_extensions_version")
    implementation("androidx.fragment:fragment-ktx:$fragment_ktx_version")


    //ROOM
    val room_version = "2.4.2"
    implementation("androidx.room:room-ktx:$room_version")
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")


    //splashScreen
    val splashscreen_version = "1.0.0-beta02"
    implementation("androidx.core:core-splashscreen:$splashscreen_version")

    //Timber+Logger for Log
    val timber_version = "5.0.1"
    implementation("com.jakewharton.timber:timber:$timber_version")
    val logger_version = "2.2.0"
    implementation("com.orhanobut:logger:$logger_version")

    //gson
    val gson_version = "2.9.0"
    implementation("com.google.code.gson:gson:$gson_version")

    //dagger
    val dagger_version = "2.42"
    val assisted_dagger_inject_version = "0.5.2"
    implementation("com.google.dagger:dagger:$dagger_version")
    kapt("com.google.dagger:dagger-compiler:$dagger_version")
    implementation("com.google.dagger:dagger-android-support:$dagger_version")
    kapt("com.google.dagger:dagger-android-processor:$dagger_version")

    compileOnly("com.squareup.inject:assisted-inject-annotations-dagger2:$assisted_dagger_inject_version")
    kapt("com.squareup.inject:assisted-inject-processor-dagger2:$assisted_dagger_inject_version")

    //Kaspresso
    val kaspresso_latest_version = "1.4.1"
    androidTestImplementation("com.kaspersky.android-components:kaspresso:$kaspresso_latest_version")
    // Allure support
    androidTestImplementation("com.kaspersky.android-components:kaspresso-allure-support:$kaspresso_latest_version")
    // Jetpack Compose support
    androidTestImplementation("com.kaspersky.android-components:kaspresso-compose-support:$kaspresso_latest_version")

    val fragment_version = "1.4.1"
    debugImplementation("androidx.fragment:fragment-testing:$fragment_version")

    //Espresso
    val espresso_version = "3.3.0"
    androidTestImplementation("androidx.test.espresso:espresso-core:$espresso_version")
    androidTestImplementation("com.android.support.test.espresso:espresso-contrib:$espresso_version")

    //Mockito
    val mockito_latest_version = "4.1.0"
    val nhaarman_mockito_latest_version = "1.5.0"
    testImplementation("org.mockito:mockito-core:$mockito_latest_version")
    testImplementation("org.mockito:mockito-inline:$mockito_latest_version")
    testImplementation("com.nhaarman:mockito-kotlin:$nhaarman_mockito_latest_version") {
        exclude(group = "org.jetbrains.kotlin")
        exclude(group = "org.mockito")
    }
}


