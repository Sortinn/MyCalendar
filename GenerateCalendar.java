import java.util.*;


public class GenerateCalendar {
    private Map<Integer, Integer> monthAndDay = new LinkedHashMap<>();
    private final int DAY_28 = 28;
    private final int DAY_29 = 29;
    private final int DAY_30 = 30;
    private final int DAY_31 = 31;

    private String week = "日" + "\t" + "一" + "\t" + "二" + "\t" + "三" + "\t" + "四" + "\t" + "五" + "\t" + "六" + "\t";


    public int findFirstDay(int month, int year) {
        CalculateWeek cal = new CalculateWeek();
        return cal.week(1, month, year);

    }

    public boolean judgeMonth_30(int month) {
        return month == 4 || month == 6 || month == 9 || month == 11;
    }

    public int days(int month) {
        MyCalendar ca = new MyCalendar();
        if (month == 2) {
            return DAY_29;
        } else if (judgeMonth_30(month)) {
            return DAY_30;
        }
        return DAY_31;
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
                printDays(findFirstDay(entry.getKey(), year), DAY_30);
                System.out.println();
            } else if (entry.getKey() == 2) {
                if (my.isLeapYear(year)) {
                    printDays(findFirstDay(entry.getKey(), year), DAY_29);
                } else printDays(findFirstDay(entry.getKey(), year), DAY_28);

                System.out.println();
            } else {
                printDays(findFirstDay(entry.getKey(), year), DAY_31);
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


//    public static void main(String[] args) {
//        System.out.println("以下是结果");
//        GenerateCalendar gene = new GenerateCalendar(2001);
//        for (int value : gene.monthAndDay.keySet()) {
//            System.out.println(value);
//            System.out.println(gene.monthAndDay.get(value) + "天");
//        }
//    }
}
