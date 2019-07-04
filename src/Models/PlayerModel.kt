package Models

data class PlayerModel(
    var money: Int = 0,
    var protectionField: Int = 30,
    var entanglements: Int = 30,
    var tents: Int = 3,
    var people: Int = 3,
    var day: Int,
    var isUpgradeAvailable: Boolean,
    val tentCost: Int = 1,
    val entanglementsCost: Int = 10,
    val protectionFieldCost: Int = 2
)