package Models

data class PlayerModel(
    var money: Int = 0,
    var protectionField: Int = 30,
    var entanglements: Int = 30,
    var tents: Int = 3,
    var people: Int = tents * 3
    )