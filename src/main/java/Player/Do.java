

import java.util.Calendar;

public class Do {
    public static int virtual_day = 0;

    public static int Get_Day_Week() {
        Calendar calendar = Calendar.getInstance();
        int day_week = calendar.get(Calendar.DAY_OF_WEEK);
        return day_week;
    }

    //把存的钱，取出来
    public static String GetMoney(Player p) {
        // 获取存了几天
        Calendar cal = Calendar.getInstance();
        int now_Year = cal.get(Calendar.YEAR);
        int now_DayofYear = cal.get(Calendar.DAY_OF_YEAR);
        int day = (now_Year - p.Year) * 365 + now_DayofYear - p.DayofYear;
        if (virtual_day == 7) {
            day = 6;
        }
        int in = p.Save_Money_Num;
        int out = 0;
        if (p.kind == "死期") {
            out = (int) (in * (1 + 0.01 * day));
        }
        if (p.kind == "p2p") {
            out = (int) (in * Math.pow(1.02, day));
            if ((int) (Math.random() * 100) <= 6) {
                out = 0;
            }
        }
        p.Save_Money_Num = 0;
        p.money += out;
        String add_text = "";
        if (out == 0) {
            add_text = ",你血本无归了";
        }
        return String.format("这笔%s你存了%s天,本金%s,本利得%s" + add_text, p.kind, day, in, out);
    }

    public static String Update(Player p) {
        Level this_level = Level.LevelList[p.level];
        // 升级判断开始
        if (p.level == 0) {
            // 需要打工二十次即刻
            if (p.work_times == 20) {
                p.work_times = 0;
                return "已经工作二十次了，升到下一级！";
            }
        }
        if (p.level == 1) {
           // 需要某种东西
        }
        if (p.level == 2) {
            // 需要某种东西
        }
        if (p.level == 3) {
            // 需要某种东西
        }
        if (p.level == 4) {
            // 需要某种东西
        }
        if (p.level == 5) {
            // 需要某种东西
        }
        if (p.level == 6) {
            // 需要某种东西
        }
        if (p.level == 7) {
            // 需要某种东西
        }
        if (p.level == 8) {
            // 需要某种东西
        }
        if (p.level == 9) {
            // 需要某种东西
        }
        if (p.level == 10) {
            // 需要某种东西
        }
        if (p.level == 11) {
            // 需要某种东西
        }
        return "空";
    }


    //存钱
    public static String SaveMoney(Player p, int save_money, String kind) {
        if (p.money < save_money) {
            return "你的全部金额不足" + save_money + "元";
        }
        int day_week = Get_Day_Week();
        if (day_week == 7) {
            return "今天是周日，本银行不提供存钱业务,只提供取钱业务！";
        }
        if (virtual_day == 7) {
            return "今天是周末，本银行不提供存钱业务,只提供取钱业务！";
        }
        if (p.Save_Money_Num != 0) {
            return "你已经存过钱了，不能再次存储";
        }
        // 真正存钱成功
        p.Save_Money_Num = save_money;
        p.kind = kind;
        p.money -= save_money;
        Calendar cal = Calendar.getInstance();
        p.Year = cal.get(Calendar.YEAR);
        p.DayofYear = cal.get(Calendar.DAY_OF_YEAR);
        return "你在银行存了" + save_money + "元" + kind + ",手里还剩下" + p.money + "元";
    }
}
