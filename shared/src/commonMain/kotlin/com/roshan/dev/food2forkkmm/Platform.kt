package com.roshan.dev.food2forkkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform