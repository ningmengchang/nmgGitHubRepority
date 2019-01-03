package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		String currentTime=df.format(System.currentTimeMillis());
        System.out.println(currentTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time=df.parse(currentTime);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(time);
        rightNow.add(Calendar.DAY_OF_YEAR,3);//日期加10天
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
        System.out.println(reStr);
        System.out.println(time);
	}

}
