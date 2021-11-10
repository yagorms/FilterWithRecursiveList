package com.example.demo

import java.util.*
import java.util.stream.Collectors

class Test {

    val subNodes1: PlayNode = PlayNode(1, "PERSON", "TASK", listOf(), true, "TRUE")
    val subNodes2: PlayNode = PlayNode(2, "PERSON", "TASK", listOf(), false, "TRUE")
    val subNodes3: PlayNode = PlayNode(3, "PERSON", "TASK", listOf(), true, "TRUE")

    val subNodesx: PlayNode = PlayNode(99, "PERSON","BLABLA", listOf(subNodes1, subNodes2, subNodes3), false, "TRUE")
    val subnodes4: PlayNode = PlayNode(4, "PERSON","BLABLA", listOf(subNodesx), false, "TRUE")

    val playGame: PlayGame = PlayGame(
        UUID.randomUUID().toString(),
        "111",
        "111",
        true,
        PlayNode(1, "PERSON", "BLABLA", listOf(subNodesx), false, "TRUE")
    )

    val playGame2: PlayGame = PlayGame(
        UUID.randomUUID().toString(),
        "111",
        "111",
        true,
        PlayNode(1, "PERSON", "BLABLA", listOf(subNodes1), false, "TRUE")
    )

    val playGameEnabled = listOf(playGame, playGame2)

    fun executa() {

        val gameFiltered = playGameEnabled.stream().filter {it -> filtrar(it.mainNode)}

        println(gameFiltered.collect(Collectors.toList()))

    }

    private fun filtrar(playNode: PlayNode): Boolean {

        return if(playNode.nodeType == "TASK"){

            playNode.taskType == "PERSON" && !playNode.finished && playNode.achievementStatus != "PENDING"

        } else{

            playNode.subNodes.any{filtrar(it)}

        }

    }
}