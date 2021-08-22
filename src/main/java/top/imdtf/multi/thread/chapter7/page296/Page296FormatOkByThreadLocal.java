package top.imdtf.multi.thread.chapter7.page296;

import top.imdtf.multi.thread.utils.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 20:23
 */
public class Page296FormatOkByThreadLocal {
    public static void main(String[] args) {
        String[] dateStringArray = new String[]{"2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04", "2000-01-05", "2000-01-06", "2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10"};
        for (int i = 0; i < Constant.INT_10; ++i) {
            new MyThread(dateStringArray[i]).start();
        }
    }
}

class DateTools {
    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<>();
    public static SimpleDateFormat getSimpleDateFormatInstance(String datePattern) {
        SimpleDateFormat simpleDateFormat = SIMPLE_DATE_FORMAT_THREAD_LOCAL.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(datePattern);
            SIMPLE_DATE_FORMAT_THREAD_LOCAL.set(simpleDateFormat);
        }
        SIMPLE_DATE_FORMAT_THREAD_LOCAL.remove();
        return simpleDateFormat;
    }
}

class MyThread extends Thread {
    private final String dateString;

    public MyThread(String dateString) {
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            String formatPattern = "yyyy-MM-dd";
            Date date = DateTools.getSimpleDateFormatInstance(formatPattern).parse(dateString);
            String newDateString = DateTools.getSimpleDateFormatInstance(formatPattern).format(date);
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName: " + getName() + " transfer error, transfer date from " + dateString + " -> " + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
