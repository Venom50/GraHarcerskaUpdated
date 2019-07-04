package Controllers

import Models.MenuModel
import Views.MenuView
import java.util.*

open class MenuController(receivedGameController: GameController, receivedMenuModel: MenuModel, receivedMenuView: MenuView) {

    private val menuModel = receivedMenuModel
    private val menuView = receivedMenuView
    private val gameController = receivedGameController

    fun startMenu() {
        menuView.showMenu()
        chooseOption()
    }

    fun chooseOption() {
        val input = Scanner(System.`in`)
        var option = input.nextLine()

        while(option != "1" && option != "2" && option != "3") {
            println("Bledna opcja, sprobuj ponownie")
            menuView.showMenu()
            option = input.nextLine()
        }

        when(option) {
            "1" -> gameController.startGame()
            "2" -> showHighestAmountOfMoney()
            "3" -> println("Game is over")
        }
    }

    fun showHighestAmountOfMoney() {
        println(menuModel.highestAmountOfMoney)
    }

}