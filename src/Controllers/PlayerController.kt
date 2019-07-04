package Controllers

import Models.PlayerModel
import Views.PlayerView
import java.util.*

open class PlayerController(private val playerModel: PlayerModel,
                            private val playerView: PlayerView) {

    fun newDay() {
        playerModel.day++
        playerModel.money += playerModel.day * 10
        playerModel.isUpgradeAvailable = true
        playerView.showInformationAboutPlayer()
    }

    fun buyTents() {
        if (playerModel.money >= (playerModel.tentCost * playerModel.day)) {
            playerModel.tents += 1
            playerModel.money -= (playerModel.tentCost * playerModel.day)

            playerModel.isUpgradeAvailable = false
        } else {
            println("Nie wystarczajaco pieniedzy")
        }
    }

    fun buyEntanglements() {
        if (playerModel.money >= (playerModel.entanglementsCost * playerModel.day)) {
            playerModel.entanglements += 10
            playerModel.money -= (playerModel.tentCost * playerModel.day)

            playerModel.isUpgradeAvailable = false
        } else {
            println("Nie wystarczajaco pieniedzy")
        }
    }

    fun buyProtectionField() {
        if (playerModel.money >= (playerModel.protectionFieldCost * playerModel.day)) {
            playerModel.protectionField += 10
            playerModel.money -= (playerModel.protectionFieldCost * playerModel.day)

            playerModel.isUpgradeAvailable = false
        } else {
            println("Nie wystarczajaco pieniedzy")
        }
    }

    fun buyDefences() {
        if (playerModel.isUpgradeAvailable) {
            playerView.showBuyDefenceMenu()

            val input = Scanner(System.`in`)
            var option = input.nextLine()

            while (option != "1" && option != "2" && option != "3" && option != "4") {
                println("Bledna opcja, sprobuj ponownie")
                playerView.showBuyDefenceMenu()
                option = input.nextLine()
            }

            when (option) {
                "1" -> buyTents()
                "2" -> buyEntanglements()
                "3" -> buyProtectionField()
                "4" -> sellDefences()
            }
        } else {
            println("Opcja wykorzystana na ten dzien")
        }
    }

    fun sellDefences() {
        playerView.showSellDefenceMenu()

        val input = Scanner(System.`in`)
        var option = input.nextLine()

        while (option != "1" && option != "2" && option != "3") {
            println("Bledna opcja, sprobuj ponownie")
            playerView.showSellDefenceMenu()
            option = input.nextLine()
        }

        when (option) {
            "1" -> playerModel.money += (playerModel.entanglementsCost * playerModel.day)
            "2" -> playerModel.money += (playerModel.protectionFieldCost * playerModel.day)
            "3" -> buyDefences()
        }

        playerModel.isUpgradeAvailable = false
    }
}
