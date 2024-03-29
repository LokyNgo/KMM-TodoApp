plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:main"))
                implementation(project(":common:edit"))
                implementation(project(":common:root"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.Decompose.extensionsCompose)
            }
        }

        named("androidMain") {
            dependencies {
                // Workaround for https://github.com/JetBrains/compose-jb/issues/2340
                implementation("androidx.compose.foundation:foundation:${Deps.JetpackComposeWorkaround.VERSION}")
            }
        }
    }
}
