package common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @version V3.0
 * @Title: DateUtils
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/11/27 下午10:12
 */
public class DateUtils {
    //获取当天日期
    public static String getNowDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowDate = sdf.format(date);
        return nowDate;
    }

    //获取昨日日期
    public static String getYesterdayStr() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd");
        return startSdf.format(c.getTime());
    }

    //获取指定日期的前一天
    public static String getYesterdayStrBySomeDay(String day) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day1 = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day1 - 1);
        SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd");
        return startSdf.format(c.getTime());
    }

    //获取当天的开始时间
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static String getPunchedDay(String endTime) {
        String punchedDay = DateUtils.getNowDateStr();
        endTime = endTime.substring(2, 4);
        long endTimeLong = Long.parseLong(endTime);
        Date beginDay = DateUtils.getDayBegin();
        long time = beginDay.getTime() + endTimeLong * 60 * 60 * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        //打卡日期为前一天
        if (currentTimeMillis < time) {
            punchedDay = DateUtils.getYesterdayStr();
        }
        return punchedDay;
    }


}
