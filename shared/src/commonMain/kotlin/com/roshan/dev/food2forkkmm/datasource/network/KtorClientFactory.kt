package com.roshan.dev.food2forkkmm.datasource.network

import io.ktor.client.*

expect class KtorClientFactory() {
    fun build():HttpClient
}