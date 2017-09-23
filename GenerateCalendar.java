import java.util.*;


public class GenerateCalendar {
    private Map<Integer, Integer> monthAndDay = new LinkedHashMap<>();
    private final int day = 29;
    private int month;
    private String week = "日" + "\t" + "一" + "\t" + "二" + "\t" + "三" + "\t" + "四" + "\t" + "五" + "\t" + "六" + "\t";
    private int record;


    public int findFirstDay(int month, int year) {
        CalculateWeek cal = new CalculateWeek();
        int fisrtDay = cal.week(1, month, year);    //查询该年每月第一天在星期几
        return fisrtDay;

    }

    public boolean judgeMonth_30(int month) {
        return month == 4 || month == 6 || month == 9 || month == 11;
    }

    public int days(int month) {
        if (month == 2) {
            return day;
        } else if (judgeMonth_30(month)) {
            return day + 1;
        }
        return day + 2;
    }

    public void formatMap() {
        for (int i = 0; i < 12; i++) {
            monthAndDay.put((i + 1), days(i + 1));
        }
    }

    public GenerateCalendar(int year) {
        this.formatMap();
        MyCalendar my = new MyCalendar();
        for (Map.Entry<Integer, Integer> entry : monthAndDay.entrySet()) {

            System.out.println(entry.getKey() + "月");
            System.out.println("--------------------------");
            System.out.println(week);

            for (int i = 0; i < findFirstDay(entry.getKey(), year); i++) {
                System.out.print("\t");             //打印每月首的空格
            }

            if (judgeMonth_30(entry.getKey())) {
                printDays(findFirstDay(entry.getKey(), year),30);
                System.out.println();
            } else if (entry.getKey() == 2) {
                if (my.isLeapYear(year)) {
                    printDays(findFirstDay(entry.getKey(), year),29);
                }else printDays(findFirstDay(entry.getKey(), year),28);

                System.out.println();
            } else {
                printDays(findFirstDay(entry.getKey(), year), 31);
                System.out.println();
            }
        }
        System.out.println("--------------------------");
    }


    private void printDays(int tar, int dayOfMonth) {   //tar为每月前的缩进空格数
        int nextLine = 7 - tar;
        for (int i = 1; i <= dayOfMonth; i++) {
            System.out.print(i + "\t");
            if ((i - nextLine) % 7 == 0) {
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("以下是结果");
        GenerateCalendar gene = new GenerateCalendar(2001);
//        for (int value : gene.monthAndDay.keySet()) {
//            System.out.println(value);
//            System.out.println(gene.monthAndDay.get(value) + "天");
//        }

    }
}
