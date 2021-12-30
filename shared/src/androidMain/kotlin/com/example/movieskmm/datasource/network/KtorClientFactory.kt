package com.example.movieskmm.datasource.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json

actual class KtorClientFactory {

    actual fun build(): HttpClient {

        return HttpClient(Android) {
            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.BODY
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true // if the server sends extra fields, ignore them
                    }
                )
            }

        }
    }
}