plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

}

android {
    namespace = "com.example.mypraticeapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mypraticeapplication"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

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

    dataBinding.enable = true

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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")

    //Networking
    implementation ("com.squareup.retrofit2:retrofit:2.6.2")
    implementation (libs.converter.gson)
    implementation ("com.squareup.okhttp3:logging-interceptor:4.2.2")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.6.2")

    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("com.jakewharton.rxbinding3:rxbinding:3.1.0")

    // Room Database
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")


    //Image Process
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    implementation ("com.github.bumptech.glide:annotations:4.11.0")

    implementation ("com.karumi:dexter:6.0.2")

}