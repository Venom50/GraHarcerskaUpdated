package Views

import Models.EnemyModel
import Models.PlayerModel

open class PlayerView(receivedPlayerModel: PlayerModel, receivedEnemyModel: EnemyModel) {

    var enemyModel = receivedEnemyModel
    var playerModel = receivedPlayerModel

    fun showInformationAboutPlayer() {
        println("Dzien: ${playerModel.day}")
        println("Sila przeciwnika " + enemyModel.power)
        println("-----------------")
        println("Pieniadze: " + playerModel.money)
        println("Sila pola ochronnego: " + playerModel.protectionField)
        println("Sila zasiekow: " + playerModel.entanglements)
        println("Namioty: " + playerModel.tents)
        println("Ludzie: " + playerModel.people)
        println()
    }

    fun showSellDefenceMenu() {
        println("Wybierz co chcesz sprzedac")
        println("------------------")
        println("1. Sprzedaj zasieki za " + (playerModel.entanglementsCost * playerModel.day))
        println("2. Sprzedaj pole ochronne" + (playerModel.protectionFieldCost * playerModel.day))
        println("3. Wyjdz")
        println()
    }

    fun showBuyDefenceMenu() {
        println("Wybierz co opcje")
        println("-------------------")
        println("1. Kup 1 namiot za " + (playerModel.tentCost * playerModel.day))
        println("2. Kup 10 zasiekow za " + (playerModel.entanglementsCost * playerModel.day))
        println("3. Kup 10 pola ochronnego za " + (playerModel.protectionFieldCost * playerModel.day))
        println("4. Sprzedaj obrone")
        println()
    }
}