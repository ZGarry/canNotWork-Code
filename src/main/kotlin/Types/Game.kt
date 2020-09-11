package Types

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import net.mamoe.mirai.contact.User

@JsonClass(generateAdapter = true)
class Game {
    var players: HashMap<Long, Player>? = hashMapOf()
    var url: String = ""

    fun LoadPlayers(string: String) {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(HashMap::class.java, Long::class.java, Player::class.java)
        val adapter: JsonAdapter<HashMap<Long, Player>> = moshi.adapter(type)
        this.players = adapter.fromJson(string)
    }


    fun SavePlayers(): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(HashMap::class.java, Long::class.java, Player::class.java)
        val adapter: JsonAdapter<HashMap<Long, Player>> = moshi.adapter(type)
        return adapter.toJson(this.players)
    }


}