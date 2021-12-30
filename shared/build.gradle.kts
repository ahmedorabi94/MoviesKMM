plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.5.21"
}

version = "1.0"

kotlin {
    android()
    // iosX64()
    iosArm64()
    iosSimulatorArm64()
    // sure all ios dependencies support this target

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Ktor.core)
                implementation(Ktor.clientSerialization)
                // implementation(Kotlinx.datetime)
                //  implementation(SQLDelight.runtime)
            }

        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.android)
                implementation("io.ktor:ktor-client-logging:1.6.7")

                //  implementation(SQLDelight.androidDriver)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }


        // val iosX64Main by getting
        val iosArm64Main by getting {
            dependencies {
                implementation(Ktor.ios)

            }
        }
        val iosSimulatorArm64Main by getting {
            dependencies {
                implementation(Ktor.ios)

            }
        }
        val iosMain by creating {
            dependsOn(commonMain)
            //   iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        // val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            // iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }

//        val iosSimulatorArm64Main by getting {
//            dependencies {
//                implementation(Ktor.ios)
//                //  implementation(SQLDelight.nativeDriver)
//            }
//        }
//        val iosSimulatorArm64Test by getting
    }

}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}