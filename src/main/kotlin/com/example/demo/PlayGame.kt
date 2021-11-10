package com.example.demo

import java.time.LocalDateTime
import java.util.*

data class PlayGame(
    val playGameId: String,
    val personId: String,
    val accountId: String,
    var enabled: Boolean = true,
    val mainNode: PlayNode,
)
