package Controllers

import Models.MenuModel
import Views.MenuView
import java.util.*

open class MenuController {

    val menuModel = MenuModel()
    val menuView = MenuView()

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

//        do {
//            val input = Scanner(System.`in`)
//            option = input.nextLine()
//        } while(option != "1" && option != "2" && option != "3")



        when(option) {
            "1" -> startGame()
            "2" -> showHighestAmountOfMoney()
            "3" -> endGame()
        }
    }

    fun startGame() {
        println("Nowa gra start")
    }

    fun showHighestAmountOfMoney() {
        println(menuModel.highestAmountOfMoney)
    }

    fun endGame() {
        println("Koniec gry")
    }
}