package com.manpower.interimaires.app.utils

sealed class AsyncState<out T : Any> {
    data class Success<out T : Any>(val data: T? = null) : AsyncState<T>() {
        var hasBeenConsumed = false
            private set

        fun consumeContent(): T? = data?.takeIf { !hasBeenConsumed }.also { hasBeenConsumed = true }
    }

    open class Failure(private val exception: Exception) : AsyncState<Nothing>() {
        var hasBeenHandled = false
            private set

//        fun getErrorIfNotHandled(): ErrorState? = exception.takeIf { !hasBeenHandled }.let { hasBeenHandled = true; it?.toErrorState() }

//        fun getError(): ErrorState = exception.toErrorState()
//        fun getMessageRes(): Int = exception.toErrorState().getMessageRes()

    }

    data class Loading<out T : Any>(val data: T? = null) : AsyncState<T>()

    fun getOrNull(): T? =
        when {
            this is Success -> data
            this is Loading -> data
            else -> null
        }
}

/**
 * `true` if [AsyncState] is of type [Success] & holds non-null [Success.data].
 */
val AsyncState<*>.isSuccess
    get() = this is AsyncState.Success && data != null

/**
 * `true` if [AsyncState] is of type [Failure]
 */
val AsyncState<*>.isFailure
    get() = this is AsyncState.Failure

/**
 * `true` if [AsyncState] is of type [Loading]
 */
val AsyncState<*>.isLoading
    get() = this is AsyncState.Loading