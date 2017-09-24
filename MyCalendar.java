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
        String menu = "[1] Enter the year to query the calendar\n" +
                "[2] Enter a specific date for the week\n" +
                "[0] Exit";
        String errorInput = "Error Input! Please input in the correct way.";
        System.out.println("*****************  Welcome To \'My Calendar\'!   *********************\n\n" +
                "[ My Calendar ] can provide you with a calender" +
                " from 18th century, and what you need to do is just to enter the information you want to search!\n" +
                menu);
        while (true) {
            int input = reader.nextInt();
            if (input == 1) {
                System.out.println("Please enter the year to get its calendar :)");
                int year = reader.nextInt();
                GenerateCalendar gen = new GenerateCalendar(year);
                System.out.println( "\n" + menu );
            } else if (input == 2) {
                CalculateWeek query = new CalculateWeek();
                NumToWeek numToWeek = new NumToWeek();
                System.out.println("Please enter a specific date(use blank spaces to separate them :)");
                int separateYear = reader.nextInt();
                int separateMonth = reader.nextInt();
                int separateDay = reader.nextInt();
                if (separateMonth > 12 || separateMonth < 1 || separateDay > 31 || separateDay < 1) {
                    System.out.println(errorInput);
                }else {
                    int week = query.week(separateDay, separateMonth, separateYear);
                    System.out.println(separateYear + "." + separateMonth + "." + separateDay + " is " + numToWeek.weekdays[week]);
                }
                System.out.println("\n" + menu);
            } else if (input == 0) {
                System.out.println("See You!");
                System.exit(0);
            } else {
                System.out.println(errorInput);
            }
        }

    }
}
