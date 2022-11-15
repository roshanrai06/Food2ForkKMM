package com.roshan.dev.food2forkkmm.datasource.network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

actual class KtorClientFactory {
    actual fun build(): HttpClient {
        return HttpClient() {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}