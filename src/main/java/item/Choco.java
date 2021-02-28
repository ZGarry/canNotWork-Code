package item;

import Player.Player;

// java 在大小写，以及idea提示的时候，十分严格
public class Bread extends Item {

    public Bread() {
        super("面包", "体力+5", "普通", "日用品");
    }

    @Override
    public String Useby(Player p) {
        p.basic += 5;
        return "使用了面包，体力+5";
    }
}
