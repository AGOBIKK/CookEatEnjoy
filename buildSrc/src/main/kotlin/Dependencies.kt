import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "com.agobikk.cookeatenjoy"
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = 32
    val javaVersion = JavaVersion.VERSION_1_8
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    //Design
    const val appcompat = "1.4.0"
    const val material = "1.4.0"
    const val constraintlayout = "2.1.3"

    //Navigation
    const val navigationFragment = "2.4.2"
    const val navigationUiKtx = "2.4.2"

    //Preference
    const val preferenceKtx = "1.2.0"

    //View binding delegate
    const val viewBindingDelegate = "1.4.7"

    //Glide
    const val glide = "4.13.0"
    const val glideCompiler = "4.13.0"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val coroutinesAdapter = "0.9.2"
    const val okHttp = "4.8.0"
    const val loggingInterceptor = "4.8.0"

    // Gson
    const val googleCodeGson = "2.9.0"

    //Kotlin
    const val coreKtx = "1.8.0"
    const val coroutinesCore = "1.4.1"
    const val coroutinesAndroid = "1.4.1"

    //Lifecycle
    const val livedata = "2.4.1"
    const val viewmodel = "2.4.1"
    const val viewmodelSavedstate = "2.4.1"
    const val extensions = "2.2.0"
    const val fragmentKtx = "1.4.1"

    //Room
    const val roomKtx = "2.4.2"
    const val roomRuntime = "2.4.2"
    const val roomCompiler = "2.4.2"

    //splashScreen
    const val splashscreen = "1.0.0-beta02"

    //Timber + Logger for log
    const val timber = "5.0.1"
    const val logger = "2.2.0"

    //Dagger2
    const val dagger = "2.42"
    const val daggerCompiler = "2.42"
    const val daggerAndroidSupport = "2.42"
    const val daggerAndroidProcessor = "2.42"
    const val daggerAssistedInjectAnnotations = "0.5.2"
    const val daggerAssistedInjectProcessor = "0.5.2"

    //TestKaspresso
    const val kaspresso = "1.4.1"
    const val kaspressoAllureSupport = "1.4.1"

    // TestFragment
    const val testingFragment = "1.4.1"

    //TestEspresso
    const val espressoCore = "3.3.0"
    const val espressoContrib = "3.3.0"

    //TestMockito
    const val mockitoCore = "4.1.0"
    const val mockitoInline = "4.1.0"
    const val nhaarmanMockitoKotlin = "1.5.0"
    const val mockitoKotlin = "4.0.0"

    //TestUnit
    const val jUnit = "5.8.2"
//    const val testExtJunit = "1.1.3"
    const val coreTesting = "2.1.0"


    //LegacySupport
    const val legacySupport = "1.0.0"

}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
}

object Navigation {
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragment}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationUiKtx}"
}

object Preference {
    const val preferenceKtx = "androidx.preference:preference-ktx:${Versions.preferenceKtx}"
}

object ViewBindingDelegate {
    const val viewBindingDelegate =
        "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewBindingDelegate}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideCompiler}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val coroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesAdapter}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
}

object Gson {
    const val googleCodeGson = "com.google.code.gson:gson:${Versions.googleCodeGson}"
}

object Kotlin {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object Lifecycle {
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedata}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel}"
    const val viewmodelSavedstate =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.viewmodelSavedstate}"
    const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.extensions}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
}

object Room {
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomKtx}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomRuntime}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
}

object Splashscreen {
    const val splashscreen = "androidx.core:core-splashscreen:${Versions.splashscreen}"
}

object Timber {
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object Logger {
    const val logger = "com.orhanobut:logger:${Versions.logger}"
}

object Dagger2 {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerCompiler}"
    const val daggerAndroidSupport =
        "com.google.dagger:dagger-android-support:${Versions.daggerAndroidSupport}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.daggerAndroidProcessor}"
    const val daggerAssistedInjectAnnotations =
        "com.squareup.inject:assisted-inject-annotations-dagger2:${Versions.daggerAssistedInjectAnnotations}"
    const val daggerAssistedInjectProcessor =
        "com.squareup.inject:assisted-inject-processor-dagger2:${Versions.daggerAssistedInjectProcessor}"
}

object TestKasptesso {
    const val kaspresso = "com.kaspersky.android-components:kaspresso:${Versions.kaspresso}"
    const val kaspressoAllureSupport =
        "com.kaspersky.android-components:kaspresso-allure-support:${Versions.kaspressoAllureSupport}"
}

object TestFragment {
    const val testingFragment = "androidx.fragment:fragment-testing:${Versions.testingFragment}"
}

object TestEspresso {
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoContrib =
        "com.android.support.test.espresso:espresso-contrib:${Versions.espressoContrib}"
}

object TestMockito {
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val nhaarmanMockitoKotlin = "com.nhaarman:mockito-kotlin:${Versions.nhaarmanMockitoKotlin}"
   const val mockitoKotlin= "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"

}

object TestUnit {
    const val jUnit = "org.junit.jupiter:junit-jupiter:${Versions.jUnit}"
//    const val testExtJunit = "junit:junit:${Versions.testExtJunit}"
}

object LegacySupport {
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
}


