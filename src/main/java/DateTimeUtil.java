import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author FZK
 * @create 2019-08-12 14:44
 **/
public class DateTimeUtil {


    /**
     * 获取当月的第一天
     *
     * @param theDay
     * @return
     */
    public static String firstday(String theDay) {
        try {
            theDay += "-01";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cale = Calendar.getInstance();
            Date date = null;
            date = format.parse(theDay);
            cale.setTime(date);
            cale.add(Calendar.MONTH, 0);
            cale.set(Calendar.DAY_OF_MONTH, 1);
            return format.format(cale.getTime());
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    /**
     * 获取当月最后一天
     *
     * @param theDay
     * @return
     */
    public static String lastday(String theDay) {
        try {
            theDay += "-01";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cale = Calendar.getInstance();
            Date date = null;
            date = format.parse(theDay);
            cale.setTime(date);

            cale.add(Calendar.MONTH, 1);
            cale.set(Calendar.DAY_OF_MONTH, 0);
            return format.format(cale.getTime());
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 日期加指定天数
     *
     * @param date
     * @param field
     * @param number
     * @return
     */
    public static Date addDateTime(Date date, int field, int number) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(field, number);
        return c.getTime();
    }


    /**
     * 字符串转日期
     *
     * @param str
     * @param format 格式yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date str2Date(String str, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }


    /**
     * 判断是否本月
     *
     * @param dateTime
     * @return
     */
    public static boolean isThisMonth(String dateTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Date time = sdf.parse(dateTime);
            return isThisTime(time.getTime(), "yyyy-MM");
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean isThisTime(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String param = sdf.format(date);//参数时间
        String now = sdf.format(new Date());//当前时间
        if (param.equals(now)) {
            return true;
        }
        return false;
    }


    /**
     * 获取前一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    /**
     * 当天
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {//格式化为相同格式
            return true;
        } else {
            return false;
        }


    }
}
