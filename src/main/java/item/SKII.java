package item;

import Player.Player;

// java 在大小写，以及idea提示的时候，十分严格
public class JiLie extends Item {

    public JiLie() {
        super("吉列剃须刀", "使用后，获得200￥", "据说历史悠久的一种剃须工具", "收藏品");
    }

    @Override
    public String Useby(Player p) {
        p.money += 200;
        return "吉列剃须刀被卖掉了，获得200元";
    }
}
