import Controllers.GameController
import Controllers.MenuController
import Controllers.PlayerController
import Models.MenuModel
import Models.PlayerModel
import Views.MainView
import Views.MenuView
import Views.PlayerView

fun main() {
    val mainView = MainView()
    val menuView = MenuView()
    val menuModel = MenuModel()
    val gameController = GameController(mainView)
    val menuController = MenuController(gameController, menuModel, menuView)

    menuController.startMenu()


}