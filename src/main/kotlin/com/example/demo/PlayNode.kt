package com.example.demo

data class PlayNode(
    val order: Int,
    val taskType: String,
    val nodeType: String,

    val subNodes: List<PlayNode> = listOf(),

    var finished: Boolean = false,
    var achievementStatus: String
) {

}
