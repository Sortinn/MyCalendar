import java.util.Scanner;

public class MyCalendar {
    private int year;
    private int month;
    private int day;

    public boolean isLeapYear(int year) {       //判断是否为闰年
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        MyCalendar cal = new MyCalendar();
        System.out.println("*****************  Welcome To \'My Calendar\'!   *********************\n\n" +
                "[ My Calendar ] can provide you with a calender" +
                " from 18th century, and what you need to do is just to enter the year you want to search!\n");
        System.out.println("Please enter the year to get its calendar:");
        int year = reader.nextInt();
        GenerateCalendar gen = new GenerateCalendar(year);
    }
}
