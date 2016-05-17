import java.util.Calendar;

/**
 * Created by Kimjonghak on 2016. 5. 12..
 */
public class CalculateDate {
    Calendar calendar;
    private int year;
    private int month;
    private int StartDay;

    CalculateDate(){
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        int day = 1;
        calendar.set(Calendar.DATE, day);
        StartDay = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public void beforeMonth(){
        if(month > 0) {
            month--;
            calendar.set(Calendar.MONTH, month);
            StartDay = calendar.get(Calendar.DAY_OF_WEEK);
        }
    }

    public void nextMonth(){
        if(month < 11) {
            month++;
            calendar.set(Calendar.MONTH, month);
            StartDay = calendar.get(Calendar.DAY_OF_WEEK);
        }
    }

    public void beforeYear(){
        year--;
        calendar.set(Calendar.YEAR, year);
        StartDay = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public void nextYear(){
        year++;
        calendar.set(Calendar.YEAR, year);
        StartDay = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public int getCurrentMonth(){
        return month+1;
    }

    public int getCurrentYear(){
        return year;
    }

    public int[][] getCalendar(){
        final int maxWeek = 5;
        final int DaysinWeek = 7;
        int DaysinMonth;
        DaysinMonth = calendar.getActualMaximum(Calendar.DATE);
        int DayofWeek = StartDay;
        int col = 0;
        int[][] currentCalendar = new int[maxWeek][DaysinWeek];

        for(int i = 1; i <= DaysinMonth; i++){
            currentCalendar[col][DayofWeek-1] = i;
            if(DayofWeek == 7){
                col++;
                DayofWeek = 1;
            } else {
                DayofWeek++;
            }
        }

        return currentCalendar;
    }

}
