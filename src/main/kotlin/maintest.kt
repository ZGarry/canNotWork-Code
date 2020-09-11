package new

import Types.Game
import Types.Player

suspend fun main() {
    val g=Game()
    g.players?.set(1L, Player())
    print(g.SavePlayers())
}

