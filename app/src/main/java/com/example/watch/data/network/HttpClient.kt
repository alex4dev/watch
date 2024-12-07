package com.example.watch.data.network

import com.example.watch.core.Constants.ACCESS_TOKEN
import com.example.watch.core.Constants.NETWORK_TIME_OUT
import com.example.watch.core.utils.AppLogger
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


val httpClientAndroid = HttpClient(Android) {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                useAlternativeNames = true
                ignoreUnknownKeys = true
                encodeDefaults = false
            }
        )
    }

    install(HttpTimeout) {
        requestTimeoutMillis = NETWORK_TIME_OUT
        connectTimeoutMillis = NETWORK_TIME_OUT
        socketTimeoutMillis = NETWORK_TIME_OUT
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                AppLogger.debug(message)
            }
        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            AppLogger.debug("HTTP status: ${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }

    defaultRequest {
        header(HttpHeaders.Authorization, "Bearer $ACCESS_TOKEN")
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
    }
}