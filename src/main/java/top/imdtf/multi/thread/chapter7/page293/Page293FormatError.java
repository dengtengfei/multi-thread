package top.imdtf.multi.thread.chapter7.page293;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 20:04
 */
public class Page293FormatError {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray = new String[]{"2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04", "2000-01-05", "2000-01-06", "2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10"};
        for (int i = 0; i < Constant.INT_10; ++i) {
            new MyThread(simpleDateFormat, dateStringArray[i]).start();
        }
    }
}

class MyThread extends Thread {
    private final SimpleDateFormat simpleDateFormat;
    private final String dateString;

    public MyThread(SimpleDateFormat simpleDateFormat, String dateString) {
        this.simpleDateFormat = simpleDateFormat;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date date = simpleDateFormat.parse(dateString);
            String newDateString = simpleDateFormat.format(date);
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName: " + getName() + " transfer error, transfer date from " + dateString + " -> " + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
