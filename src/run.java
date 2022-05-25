import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import java.util.Date;
import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class run {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat d = new SimpleDateFormat("MM/dd/yy");
        System.out.println(d.format(date));
    }
}
