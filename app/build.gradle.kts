plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.services)
    alias(libs.plugins.firebase.appdistribution)
}

android {
    namespace = "com.kaemcorp.watch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kaemcorp.watch"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            keyAlias = findProperty("keyAlias")?.toString() ?: ""
            keyPassword = findProperty("keyPassword")?.toString() ?: ""
            storeFile = file(findProperty("storeFilePath")?.toString() ?: "/mypath")
            storePassword = findProperty("storePassword")?.toString() ?: ""
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
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
        compose = true
    }
    composeCompiler {
        enableStrongSkippingMode = true
    }
    /*    composeOptions {
            kotlinCompilerExtensionVersion = "1.5.1"
        }*/
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// Firebase App Distribution configuration
firebaseAppDistribution {
    serviceCredentialsFile =
        project.findProperty("firebaseAppDistributionFile")?.toString() ?: ""
    groups = project.findProperty("firebaseAppDistributionGroups")?.toString() ?: ""
    releaseNotes = "Automated release from Gradle"
    artifactType = "APK"
    artifactPath = project.findProperty("apkFilePath")?.toString() ?: ""
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    // navigation
    implementation(libs.voyager.navigator)
    implementation(libs.voyager.screenModel)
    implementation(libs.voyager.transitions)
    implementation(libs.voyager.koin)
    // injection
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger)
    // network
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    // image loading
    implementation(libs.coil.core)
    implementation(libs.coil.compose)
    implementation(libs.coil.network)
    // firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.runtime.compose.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}