package cookies

import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Friend
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.contact.User
import net.mamoe.mirai.contact.nameCardOrNick
import net.mamoe.mirai.message.MessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.SingleMessage
import net.mamoe.mirai.message.data.content

//甜点：地雷蜘蛛游戏
class Spider {
    companion object {
        // 游戏是否开始
        var isBegined: Boolean = false

        // 当前出题玩家
        // 必须初始化？这很奇特。静态类成员是否可以不初始化
        // user使用存在一定问题，改为使用id，避免此问题，基本上reply也可以帮助我们再次获得发送者
        var setter: User = Bot.botInstances[0].selfQQ

        // 当前词语
        var nowWord: String = ""

        //设置雷,通过携程参与
        suspend fun BeginSetMine(mes: MessageEvent) {
            if (isBegined != true) {
                mes.reply(
                    At(mes.sender as Member) + "欢迎回来，这儿是久违的蜘蛛地雷。" +
                            "\n1. 私聊面粉团，设置一个词语" +
                            "\n2. 其他人说这个词语时，踩雷"
                )
                //没能设置上
                setter = mes.sender
                setter.sendMessage("~我是可爱的面粉团，请设置一个词语作为地雷（2-4个字）")
            } else {
                mes.reply("游戏正在进行中,上一个设置地雷的人为:" + setter.nameCardOrNick)
            }
        }

        suspend fun SetMinePrivately(mes: MessageEvent) {
            mes.reply(mes.message.contentToString())
        }
    }
}