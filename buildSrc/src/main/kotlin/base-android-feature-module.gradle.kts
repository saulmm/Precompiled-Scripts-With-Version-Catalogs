plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

internal val Project.libs: VersionCatalog get() =
    project.extensions.getByType<VersionCatalogsExtension>().named("libs")


android {
    compileSdk = BuildConstants.COMPILE_SDK

    defaultConfig {
        minSdk = BuildConstants.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(libs.findLibrary("material").get())
    implementation(libs.findLibrary("core.ktx").get())
    implementation(libs.findLibrary("lifecycle.runtime.ktx").get())
    implementation(libs.findLibrary("activity.compose").get())
    implementation(platform(libs.findLibrary("compose.bom").get()))
    implementation(libs.findLibrary("ui").get())
    implementation(libs.findLibrary("ui.graphics").get())
    implementation(libs.findLibrary("ui.tooling.preview").get())
    implementation(libs.findLibrary("material3").get())
    testImplementation(libs.findLibrary("junit").get())
    androidTestImplementation(libs.findLibrary("androidx.test.ext.junit").get())
    androidTestImplementation(libs.findLibrary("espresso.core").get())
}

