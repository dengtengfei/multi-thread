package top.imdtf.multi.thread.chapter7.page295;

import top.imdtf.multi.thread.utils.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 20:17
 */
public class Page295FormatOk {
    public static void main(String[] args) {
        String[] dateStringArray = new String[]{"2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04", "2000-01-05", "2000-01-06", "2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10"};
        for (int i = 0; i < Constant.INT_10; ++i) {
            new MyThread(dateStringArray[i]).start();
        }
    }
}

class DateTools {
    public static Date parse(String formatPattern, String dateString) throws ParseException {
        return new SimpleDateFormat(formatPattern).parse(dateString);
    }

    public static String format(String formatPattern, Date date) {
        return new SimpleDateFormat(formatPattern).format(date);
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
            Date date = DateTools.parse(formatPattern, dateString);
            String newDateString = DateTools.format(formatPattern, date);
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName: " + getName() + " transfer error, transfer date from " + dateString + " -> " + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
