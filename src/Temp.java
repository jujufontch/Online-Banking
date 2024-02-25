import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.util.Scanner;

public class Temp {

    LocalDateTime currentDateTime = LocalDateTime.now();
    private int year, hour,minute,second,month ,day  ;

    public int getYear() {
         year = currentDateTime.getYear();
        return year;


    }

    public int getHour(){

         hour = currentDateTime.getHour();
        return hour;
    }

    public int getMinute(){
         minute = currentDateTime.getMinute();

        return minute;
    }

    public int getSecond(){
         second = currentDateTime.getSecond();

        return second;
    }
public int getDay(){

        day =currentDateTime.getDayOfMonth();

        return day;


}
    public int getMonth(){
        int month = currentDateTime.getMonthValue();
        return month;


    }
}
