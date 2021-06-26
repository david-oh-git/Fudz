
import io.davidosemwota.fudz.buildsource.FudzAndroidConfig
import io.davidosemwota.fudz.buildsource.Libs
import io.davidosemwota.fudz.buildsource.extentions.addUnitTestsDependencies
import io.davidosemwota.fudz.buildsource.extentions.getLocalProperty

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = FudzAndroidConfig.compileSdk
    buildToolsVersion = FudzAndroidConfig.buildToolsVersion

    defaultConfig {
        applicationId = FudzAndroidConfig.applicationId
        minSdk = FudzAndroidConfig.minSdk
        targetSdk = FudzAndroidConfig.targetSdk
        versionCode = FudzAndroidConfig.versionCode
        versionName = FudzAndroidConfig.versionName

        testInstrumentationRunner = FudzAndroidConfig.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes.forEach {
        try {
            it.buildConfigField(
                "String",
                "HERE_MAP_API_KEY",
                getLocalProperty("here.map.api.key")
            )

        } catch (ignored: Exception) {
            throw InvalidUserDataException("You should define 'here.map.api.key' " +
                    "in local.properties. Visit 'https://developer.here.com' " +
                    "to obtain them.")
        }
    }
}

dependencies {

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.material)
    implementation(Libs.AndroidX.constraintLayout)
    //Retrofit
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.retrofitgson)
    implementation(Libs.httpLogging)
    //Coroutines
    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)
    //Timber
    implementation(Libs.timber)
    // Koin
    implementation(Libs.Koin.koin)
    // Room DB
    implementation(Libs.AndroidX.Room.runtime)
    implementation(Libs.AndroidX.Room.ktx)
    kapt(Libs.AndroidX.Room.compiler)
    implementation(Libs.AndroidX.Fragment.fragmentKtx)
    implementation(Libs.AndroidX.Navigation.navigationFragment)
    implementation(Libs.AndroidX.Navigation.navigationUi)
    implementation(Libs.AndroidX.recyclerView)
    implementation(Libs.AndroidX.Lifecycle.viewmodel)
    implementation(Libs.AndroidX.Lifecycle.liveDataKtx)
    // SwipeRefreshLayout
    implementation(Libs.AndroidX.swipeRefreshLayout)

    // Unit tests
    addUnitTestsDependencies()
}