package mx.antonioyee.feedrecyclerview.util;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by antonioyee on 23/02/16.
 */
public class DateUtil {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static String getDateFormat(@NonNull Date date){
        String dateStr = DATE_FORMAT.format(date);
        return dateStr;
    }

}
