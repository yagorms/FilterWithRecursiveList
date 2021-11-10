package com.example.demo

import java.util.*

class Test {

    val subNodes1: PlayNode = PlayNode(1, "PERSON", listOf(), false, "TRUE")
    val subNodes2: PlayNode = PlayNode(2, "PERSON", listOf(), false, "TRUE")
    val subNodes3: PlayNode = PlayNode(3, "PERSON", listOf(), true, "TRUE")

    val playGame: PlayGame = PlayGame(
        UUID.randomUUID().toString(),
        "111",
        "111",
        true,
        PlayNode(1, "PERSON", listOf(subNodes1, subNodes2, subNodes3), false, "TRUE")
    )

    val playGame2: PlayGame = PlayGame(
        UUID.randomUUID().toString(),
        "111",
        "111",
        true,
        PlayNode(1, "PERSON", listOf(subNodes1), false, "TRUE")
    )

    val playGameEnabled = listOf(playGame, playGame2)


    fun executa() {

        val xxx =
            playGameEnabled.map {it -> it.mainNode.subNodes.forEach { it -> it.subNodes.any { it.taskType == "PERSON" && !it.finished && it.achievementStatus != "PENDING" } } }

        println(xxx.get(1))


    }


//    val lista2: List<String> = listOf("a", "b", "c")
//    val listaGeral: List<String> = listOf("vitor", "yago", )
//
//
//    printf(listaGeral)
}