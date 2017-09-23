import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FindCurrence {
    private Calendar ca = Calendar.getInstance();
    private int year = ca.get(Calendar.YEAR);
    private int month = ca.get(Calendar.MONTH ) + 1;        //java.util.Calendar的month是'zero based index'，即是从0开始的
    private int day = ca.get(Calendar.DATE);
    private Calendar  now = Calendar.getInstance();

    public boolean isNow(int day, int month, int year) {
        return (year == this.year && month == this.month && day == this.day) ;
    }

    public static void main(String[] args) {
        FindCurrence test = new FindCurrence();
        System.out.println(test.day + " " +  test.month + " " +  test.year);
        System.out.println(test.isNow(23, 8, 2017));
    }

}



