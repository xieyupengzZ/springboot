package com.xieyupeng.springboot.Others;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.Calendar;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;

public class OperationTime {

		public static void main(String args[]){
			//String s = createJodaTime().toString();
			boolean s = createJodaTime();
			System.out.println(s);
		}
		//创建一个joda-Time对象
		public static boolean createJodaTime(){
			//使用系统时间
			DateTime dateTime1 = new DateTime();//如果您创建了一个 DateTime 的实例，并且没有提供 Chronology(字符串编码方式) 或 DateTimeZone(时区)，Joda 将使用 ISOChronology（默认）和 DateTimeZone（来自系统设置）。
			DateTime dateTime6 = new DateTime(dateTime1.getYear(),dateTime1.getMonthOfYear(),dateTime1.getDayOfMonth(),22,0);
			dateTime1.toString("yyyy/MM/dd HH:mm:ss");
			boolean s = dateTime6.isAfterNow();
			DateTimeFormatter format = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd");
			DateMidnight dateMidnigt = new DateMidnight();//该类封装了时区，但时间只显示午夜时刻
			LocalDate localDate = new LocalDate();
			LocalTime localtime = new LocalTime();
			//精确而方便的创建时间
			DateTime dateTime2 = new DateTime(2016,1,17,11,56,40,555);//至少5个参数，最后一个三位数是毫秒
			//直接将不同的对象作为参数转
			DateTime dateTime3 = new DateTime(111111);//从19700101开始的毫秒数
			DateTime dateTime4 = new DateTime("2016-01-17T11:11:11.555+08:00");//字符串需要格式化,最后的+08:00表示时区
			DateTime dateTime5 = new DateTime(new java.util.Date());
			//处理时间
			//今年第 11 月的第一个星期二的日期
			/*LocalDate localDate2 =  now.monthOfYear() //获取对今年中的month的操作
					.setCopy(11)       
					.dayOfMonth()  //获取对该月中的day的操作
					.withMinimumValue() //该月第一天
					.plusDays(6)    //加6天
					.dayOfweek()   //获取对该week中的day的操作
					.setDay("Monday") 
					.plusDay(1);  //加1天*/			
			return s;
		}

		public void CalendarText(){
			Calendar calendar_s = Calendar.getInstance();
			Calendar calendar_e = Calendar.getInstance();

			//记住，月份起始是从0开始的！！！！！
//        calendar_s.set(2018,3,1,0,0,0);
//        calendar_e.set(2018,3,2,0,0,0);

			//设置为当前月的第一天
			calendar_e.set(Calendar.DATE,1);
			System.out.println(calendar_e.getTime());
			//设置成当前月最后一天
			calendar_s.add(Calendar.MONTH,1);
			calendar_s.set(Calendar.DATE,1);
			calendar_s.add(Calendar.DAY_OF_MONTH,-1);
			System.out.println(calendar_s.getTime());
			System.out.println(calendar_s.getActualMaximum(Calendar.DAY_OF_MONTH));//该月的最大值
			System.out.println(calendar_s.getMaximum(Calendar.DAY_OF_MONTH)); //所有该类型中，最大的，比如，1月是31天，2月是30天，返回31天
		}
}
