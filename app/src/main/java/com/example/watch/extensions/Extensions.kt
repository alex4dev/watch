package com.example.watch.extensions

import com.example.watch.core.ApiRoutes
import com.example.watch.core.Constants

fun String.createImageUrl(size: Int = Constants.DEFAULT_IMAGE_SIZE): String {
    return ApiRoutes.buildImageBaseUrl(size) + this
}

fun String.createOriginalImageUrl(): String {
    return ApiRoutes.IMAGE_500_ENDPOINT + this
}