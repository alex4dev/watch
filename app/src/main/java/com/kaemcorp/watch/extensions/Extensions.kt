package com.kaemcorp.watch.extensions

import com.kaemcorp.watch.core.ApiRoutes
import com.kaemcorp.watch.core.Constants

fun String.createImageUrl(size: Int = Constants.DEFAULT_IMAGE_SIZE): String {
    return ApiRoutes.buildImageBaseUrl(size) + this
}

fun String.createOriginalImageUrl(): String {
    return ApiRoutes.IMAGE_500_ENDPOINT + this
}