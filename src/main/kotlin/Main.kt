package net.mamoe.mirai.simpleloader

import Types.Game
import Types.Player
import cookies.Spider
import net.mamoe.mirai.Bot
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.join
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.event.subscribeMessages
import net.mamoe.mirai.message.data.source

//面粉团账号密码：
//1160458195
//dijinguoji050711

suspend fun main() {
//    val qqId = 1160458195L//Bot的QQ号，需为Long类型，在结尾处添加大写L
//    val password = "dijinguoji050711"//Bot的密码
//    BotConfiguration.Default.fileBasedDeviceInfo()
    val qqId = 2290773524
    val password = "Garry194278"
    val miraiBot = Bot(qqId, password).alsoLogin()//新建Bot并登录
    val _Game = Game()
    miraiBot.subscribeMessages {
        case("查看") {
            if (!_Game.players?.containsKey(sender.id)!!) {
                reply(At(sender as Member) + "您这是第一次游戏，已经为你创建角色")
                _Game.players!![sender.id] = Player()
            }
            val p = _Game.players!!.getValue(sender.id)
            reply(At(sender as Member) + Player().Look())
        }

        case("游戏") {
            Spider.BeginSetMine(this)
        }

        //私发
        (sentByFriend() or sentByTemp()).invoke {
            if(Spider.setter!!.id == sender.id){
                Spider.SetMinePrivately(this)
            }

        }

        //全部消息
        always {

        }

    }

//        case("退出") {
//            reply(Game.Save())
//        }

miraiBot.join() // 等待 Bot 离线, 避免主线程退出
}