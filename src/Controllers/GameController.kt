package Controllers

import Models.EnemyModel
import Models.PlayerModel
import Views.MainView
import Views.PlayerView
import java.util.*

class GameController(receiveMainView: MainView) {
    private val mainView = receiveMainView
    private val playerModel = PlayerModel()
    private val enemyModel = EnemyModel()
    private val playerView = PlayerView(playerModel, enemyModel)
    private val playerController = PlayerController(playerModel, PlayerView)
    var isTheEndOfTheGame = false

    fun startGame() {
        while(!isTheEndOfTheGame) {
            var isTheEndOfTheDay = false
            newPoepleComing()
            playerController.newDay()`
            increaseEnemyAttack()
            while (!isTheEndOfTheDay) {
                selectOption()
                isTheEndOfTheDay = true
            }
        }


    }

    private fun attack() {
        if(playerModel.entanglements >= enemyModel.power) {
            println("Zasieki odparly przeciwnika")
            playerModel.entanglements -= enemyModel.power
        } else {
            println("Zasieki nie wytrzymaly")
            playerModel.entanglements = 0
            val differenceBetweenAttackAndDefence = playerModel.protectionField.toDouble() / enemyModel.power.toDouble()

            when {
                differenceBetweenAttackAndDefence >= 2.0 -> println("Pole ochornne obronilo mieszkancow")
                differenceBetweenAttackAndDefence >= 1.75 -> {
                    val peopleLost = playerModel.people * 0.25
                    showmsdsd(peopleLost)
                    playerModel.people -= peopleLost.toInt()

                }
                differenceBetweenAttackAndDefence >= 1.5 -> {
                    val peopleLost = playerModel.people * 0.5
                    showmsdsd(peopleLost)
                    playerModel.people -= peopleLost.toInt()

                }
                differenceBetweenAttackAndDefence > 1 && differenceBetweenAttackAndDefence < 1.5  -> {
                    val peopleLost = playerModel.people * 0.75
                    showmsdsd(peopleLost)
                    playerModel.people -= peopleLost.toInt()

                }
                differenceBetweenAttackAndDefence <= 1.0 -> {
                    println("Potwory przebily sie porzez pole ochronne i zabraly wszystkich ludzi")
                    playerModel.people = 0
                    endGame()
                }
            }
        }
    }

    private fun showmsdsd(peopleLost: Double) {
        println("Potwory porwaly $peopleLost")
    }

    private fun selectOption() {
        mainView.gameMainInformation()

        val input = Scanner(System.`in`)
        var option = input.nextLine()

        while (option != "1" && option != "2" && option != "3" && option != "4") {
            println("Bledna opcja, sprobuj ponownie")
            playerView.showBuyDefenceMenu()
            option = input.nextLine()
        }

        when(option) {
            "1" -> {
                playerView.showInformationAboutPlayer()
                selectOption()
            }
            "2" -> {
                playerController.buyDefences()
                selectOption()
            }
            "3" -> attack()
            "4" -> endGame()
        }
    }

    private fun newPoepleComing() {
        val random = (0..10).random()
        println("Przybylo " + random + " nowych ludzi do obozu")
        if((playerModel.people + random) / 3 <= playerModel.tents) {
            playerModel.people += random
            println( "Ludzie zajeli miejsce w obozie")
        } else {
            println("Przybylo zbyt wielu ludzi i nie mieszcza sie w obozie, zajma tyle miejsc ile sie da")
            val differenceInPeople = (playerModel.tents * 3) - playerModel.people
            playerModel.people += differenceInPeople
        }
    }

    private fun endGame() {
        mainView.endOfTheGame()
        isTheEndOfTheGame = true
    }

    private fun increaseEnemyAttack() {
        val random = (0..10).random()
        enemyModel.power += random
    }
}