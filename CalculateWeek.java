public class CalculateWeek {
    private int endOfYear;           //2015 = 2000 + 15,即endOfYear = 15
    private int yearCode;            //年份代码=> yearCode = (endOfYear / 4 + endOfYear) % 7
    private int monthCode;


    public int getMonthCode(int month, int year) {
        MyCalendar ca = new MyCalendar();
        switch (month) {
            case 5:
                monthCode = 0;
                break;
            case 8:
                monthCode = 1;
                break;
            case 2:
            case 3:
            case 11:
                monthCode = 2;
                break;
            case 6:
                monthCode = 3;
                break;
            case 9:
            case 12:
                monthCode = 4;
                break;
            case 4:
            case 7:
                monthCode = 5;
                break;
            case 1:
            case 10:
                monthCode = 6;
                break;
        }
        if (ca.isLeapYear(year)) {
            if (month == 1) {
                monthCode = 5;
            }
            if (month == 2) {
                monthCode = 1;
            }
        }
        return monthCode;
    }

    public int week(int day, int month, int year) {
        int century = year / 100;
        int week;
        endOfYear = year % 100;
        yearCode = (endOfYear / 4 + endOfYear) % 7;
        monthCode = getMonthCode(month, year);
        if ((century - 17) % 4 == 3) {//21世纪
            // week = (yearCode + monthCode + day) % 7;
        }
        if ((century - 17) % 4 == 1) {
            yearCode += 3;
            // week = (yearCode + monthCode + day) % 7;
        }
        if ((century - 17) % 4 == 0) {
            yearCode += 5;
            //week = (yearCode + monthCode + day) % 7;
        }
        if ((century - 17) % 4 == 2) {
            yearCode += 1;
            //week = (yearCode + monthCode + day) % 7;
        }
        week = (yearCode + monthCode + day) % 7;
        return week;

    }

    //public static void main(String[] args) {
    //CalculateWeek test = new CalculateWeek();
    // int monthC = test.getMonthCode(2, 2016);
    //  System.out.println(monthC);
    //int week = test.week(10, 5, 2018);
    //  System.out.println(week);
    //}
}
