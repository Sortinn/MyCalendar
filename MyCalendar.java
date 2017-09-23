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
        System.out.println("Please enter the calendar year you want to generate:");
        int year = reader.nextInt();
        GenerateCalendar gen = new GenerateCalendar(year);
    }
}
