package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.retry.annotation.Retryable

@Controller
open class RetryController {

    @Get
    @Retryable(
        value = [RuntimeException::class],
        delay = "100ms",
        multiplier = "2",
        attempts = "10",
    )
    open fun retryMe() {
        throw RuntimeException("Try again")
    }
}
