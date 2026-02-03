plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.myapplication.ui"
    compileSdk {
        version = release(36)
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.metro.android)
    implementation(libs.metro.viewModelCompose)
    implementation(libs.metro.viewModel)
    implementation(libs.androidx.material3)
}