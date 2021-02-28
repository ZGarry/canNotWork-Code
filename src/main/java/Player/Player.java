import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Player {
    public int Save_Money_Num = 0;
    public String kind = "";
    //    public LocalTime save_time=LocalTime.now();
    public int Year = 2020;
    public int DayofYear = 0;
    public int work_times;
    public Map<String, Integer> _package = new HashMap();

    static public Map<Long, Player> PlayerMAP = new HashMap();

    static public void Create(Long id, String name) {
        Player newPalyer = new Player(id, name);
        PlayerMAP.put(id, newPalyer);
    }

    static public void Load() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("p.json"));
        String str = "";
        String line = "";
        while ((line = in.readLine()) != null) {
            str += line;
        }
        HashMap<Long, Player> map =
                JSON.parseObject(str, new TypeReference<HashMap<Long, Player>>() {
                });
        PlayerMAP = map;
    }

    // 对我而言，找到就好
    static public void Save() throws IOException {
        String jstr = JSON.toJSONString(Player.PlayerMAP);
        File f = new File("p.json");
        if (!f.exists()) {
            f.createNewFile();
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        out.write(jstr);
        out.close();
        System.out.println("文件创建成功！");

    }

    public Player() {
    }

    public Player(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long id = 0L;
    public String name = "";

    // 有了良好的跳转之后，代码排版都不需要了

    // 决定工资
    public int level = 0;

    //日工资
    public int money = 10000;
    public int salary = 100;

    //体力&上限
    public int basic = 24;
    public int max_basic = 24;
    //健康&上限
    public int health = 10;
    public int max_health = 10;

    private String ShowItems() {
        _package.put("内测之书", 1);
        if (_package.isEmpty()) {
            return "空";
        }

        StringBuilder s = new StringBuilder("");
        for (String key : _package.keySet()) {
            s.append(key + "`" + _package.get(key) + ",");
        }
        // 最后一个不取
        return s.substring(0, s.length() - 2);
    }

    public String Look() {
        Level this_level = Level.LevelList[level];
        return String.format(
                "%s LV.%s\n" +
                        "存款: %s￥\n" +
                        "工资: %s￥/月\n" +
                        "体力: %s/%s\n" +
                        "健康: %s/%s\n" +
                        "物品：%s",
                this_level.des, this_level.L,
                money,
                salary * 30,
                basic, max_basic,
                health, max_health,
                ShowItems()
        );
    }

    public static String Show() {
        return JSON.toJSONString(Player.PlayerMAP);
    }

    //打工是不可能打工的
    public String work() {
        Level this_level = Level.LevelList[level];

        //如果健康/体力扣除到零，就不然打工
        if (health <= this_level.lose_health) {
            return "你的健康不够用了,打工被拒绝";
        }
        if (basic <= this_level.lose_basic) {
            return "你的体力不够用了，打工被拒绝";
        }
        //打工成功
        work_times += 1;
        salary += this_level.salary;
        health -= this_level.lose_health;
        basic -= this_level.lose_basic;

        String res = this_level.work_say;
        return res;
    }
}
