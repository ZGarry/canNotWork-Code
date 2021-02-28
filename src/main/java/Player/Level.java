public class Level {
    // 1-9
    public int L;
    public String des;
    public int salary;
    public int lose_health;
    public int lose_basic;
    public String work_say;

    public Level(int L, String des, int salary, int lose_basic, int lose_health, String work_say) {
        this.L = L;
        this.des = des;
        this.salary = salary;
        this.lose_basic = lose_basic;
        this.lose_health = lose_health;
        this.work_say = work_say;
    }

    static public Level[] LevelList =
            {
                    new Level(1, "农民工", 100,12,1,
                            "你恨透了这该死的工作，一天工作十二个小时换来微薄的100元收入。体力-12,健康-1"),
                    new Level(2, "熟练农民工", 170,15,1,
                            "虚脱/疲惫，只有包工头每次给的170块，有点真实感。体力-15,健康-1"),
                    new Level(3, "泥瓦匠", 260,14,2,
                            "别人大概率干不了这个。这是你能拿260￥/天的理由。体力-12,健康-2"),
                    new Level(4,"合同工",230,12,1,
                            "你开始吸烟，小组长也和你称兄道弟。收入230￥，体力-12，健康-1"),
                    new Level(5,"小组长",330,13,1,
                            "干活仍需要身体力行，中间管理并不好混。收入330，体力-13，健康-1"),

                    new Level(6,"小包工头",700,10,1,
                            "你看着手下那些工人么，他们都比你累，但你赚的比他们都多。" +
                                    "收入330，体力-10，健康-1"),
                    new Level(6,"税务局工程工程长",800,7,2,
                            "你成为了组长。收入330，体力-7，健康-2"),
                    new Level(7,"局长司机",430,22,3,
                            "局长频繁参加各种酒局，你的收入往往来自红包。收入430，体力-22，健康-3"),
                    new Level(8,"局长心腹",1000,13,4,
                            "局长对你愈加信任，一些脏活经常交给你去做。收入1000，体力-13，健康-4"),
                    new Level(9,"办事员",200,13,1,
                            "你明白，这是局长的栽培，再苦你也要熬下去。收入200，体力-13，健康-1"),
                    new Level(10,"科长",2000,13,0,
                            "秘书总是能帮你做好一切，不断有人上门前来送礼。收入2000，体力-13，健康-0"),
                    new Level(11,"副局长",8000,8,0,
                            "权力的味道，妙不可言，你实在是对钱没有兴趣了。收入8000，体力-8，健康-3"),


            };

    // 升级条件，直接代码写在update函数中
}
