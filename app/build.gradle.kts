import io.davidosemwota.fudz.buildsource.FudzAndroidConfig
import io.davidosemwota.fudz.buildsource.Libs

plugins {
    id("com.android.application")
    id("kotlin-android")
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
}

dependencies {

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.material)
    implementation(Libs.AndroidX.constraintLayout)
}