import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.internal.impldep.org.fusesource.jansi.AnsiRenderer.test
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
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Releases.versionCode
        versionName = Releases.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas")
            }
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()

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
                "String", "TYPE", "\"FAKE\""
            )
        }
        create("real") {
            applicationIdSuffix = ".real"
            versionNameSuffix = "-real"
            buildConfigField("String", "TYPE", "\"REAL\"")
        }
    }
}


dependencies {

    //Design
    implementation(Design.appcompat)
    implementation(Design.material)
    implementation(Design.constraintlayout)

    //Image processing
    implementation(Glide.glide)
    annotationProcessor(Glide.glideCompiler)

    //Androidx legacy-support
    implementation(LegacySupport.legacySupport)


    //Navigation
    implementation(Navigation.navigationFragment)
    implementation(Navigation.navigationUiKtx)

    //Shared preference
    implementation(Preference.preferenceKtx)

    //ViewBindingDelegate by Kirill Rozov
    implementation(ViewBindingDelegate.viewBindingDelegate)

    //Network
    implementation(Retrofit.retrofit)
    implementation(Retrofit.converterGson)
    implementation(Retrofit.coroutinesAdapter)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.loggingInterceptor)

    implementation(Gson.googleCodeGson)

    //Kotlin-(coroutines)
    implementation(Kotlin.coreKtx)
    implementation(Kotlin.coroutinesCore)
    implementation(Kotlin.coroutinesAndroid)

    //Lifecycle
    implementation(Lifecycle.livedata)
    implementation(Lifecycle.viewmodel)
    implementation(Lifecycle.viewmodelSavedstate)
    implementation(Lifecycle.extensions)
    implementation(Lifecycle.fragmentKtx)

    //Room
    implementation(Room.roomKtx)
    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)

    //Splashscreen
    implementation(Splashscreen.splashscreen)

    //Logg
    implementation(Timber.timber)
    implementation(Logger.logger)

    //Dependency injection
    implementation(Dagger2.dagger)
    kapt(Dagger2.daggerCompiler)
    implementation(Dagger2.daggerAndroidSupport)
    kapt(Dagger2.daggerAndroidProcessor)
    compileOnly(Dagger2.daggerAssistedInjectAnnotations)
    kapt(Dagger2.daggerAssistedInjectProcessor)

    //Test
    androidTestImplementation(TestKasptesso.kaspresso)
    androidTestImplementation(TestKasptesso.kaspressoAllureSupport)
    debugImplementation(TestFragment.testingFragment)

    androidTestImplementation(TestEspresso.espressoCore)
    androidTestImplementation(TestEspresso.espressoContrib)

    testImplementation(TestMockito.mockitoCore)
    testImplementation(TestMockito.mockitoInline)
    testImplementation(TestMockito.mockitoKotlin) {
        testImplementation(TestMockito.nhaarmanMockitoKotlin) {
            exclude(group = "org.jetbrains.kotlin")
            exclude(group = "org.mockito")
        }

        testImplementation(TestUnit.jUnit)
//        androidTestImplementation(TestUnit.testExtJunit)
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    }
}


