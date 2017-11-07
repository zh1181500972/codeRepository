package com.zhanghao.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.expression.spel.ast.BooleanLiteral;

public class DateUtils {
	/**
	 * Number of milliseconds in a standard second.
	 */
	public static final long MILLIS_PER_SECOND = 1000;
	/**
	 * Number of milliseconds in a standard minute.
	 */
	public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
	/**
	 * Number of milliseconds in a standard hour.
	 */
	public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;
	/**
	 * Number of milliseconds in a standard day.
	 */
	public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

	/**
	 * ISO8601 formatter for date without time zone. The format used is
	 * <tt>yyyy-MM-dd</tt>.
	 */
	public static final FastDateFormat DATE_FORMAT = FastDateFormat
			.getInstance("yyyy-MM-dd");

	/**
	 * ISO8601 formatter for date-time without time zone. The format used is
	 * <tt>yyyy-MM-dd HH:mm:ss</tt>.
	 */
	public static final FastDateFormat DATETIME_FORMAT = FastDateFormat
			.getInstance("yyyy-MM-dd HH:mm:ss");

	/**
	 * Compact ISO8601 date format yyyyMMdd
	 */
	public static final String COMPACT_DATE_FORMAT_PATTERN = "yyyyMMdd";

	/**
	 * ISO8601 date format: yyyy-MM-dd
	 */
	public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

	/**
	 * ISO8601 date-time format: yyyy-MM-dd HH:mm:ss
	 */
	public static String DATETIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * DateUtils instances should NOT be constructed in standard programming.
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean
	 * instance to operate.
	 */
	public DateUtils() {
	}

	/**
	 * 格式化年月日
	 * @param str
	 * @return
	 */
	public static Date parse(String str) {
		return parse(str, DATE_FORMAT_PATTERN);
	}
	
	/**
	 * 格式化年月日 时分秒
	 * @param str
	 * @return
	 */
	public static Date parseDateTime(String str) {
		return parse(str, DATETIME_FORMAT_PATTERN);
	}

	/**
	 * 按指定格式格式化时间
	 * @param str 日期字符串
	 * @param pattern 日期格式，通过DateUtilsDATETIME_FORMAT
	 * @return
	 */
	public static Date parse(String str, String pattern) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		DateFormat parser = new SimpleDateFormat(pattern);
		try {
			return parser.parse(str);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Can't parse " + str + " using "
					+ pattern);
		}
	}

	public static String format(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		FastDateFormat df = FastDateFormat.getInstance(pattern);
		return df.format(date);
	}

    public static String toString(Date date){
        return date == null ? null : DATETIME_FORMAT.format(date);
    }

	/**
	 * return date format is <code>yyyy-MM-dd</code>
	 */
	public static String format(Date date) {
		return date == null ? null : DATE_FORMAT.format(date);
	}

	/**
	 * return date format is <code>yyyy-MM-dd</code>
	 */
	public static String getCurrentDateAsString() {
		return DATE_FORMAT.format(new Date());
	}
	
	public static String getMathDate(int day) {
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DAY_OF_MONTH, day); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
		String mDateTime=formatter.format(c.getTime());   
		return mDateTime;
	}

	public static String getCurrentDateAsString(String pattern) {
		FastDateFormat formatter = FastDateFormat.getInstance(pattern);
		return formatter.format(new Date());
	}

	/**
	 * return date format is <code>yyyy-MM-dd HH:mm:ss</code>
	 */
	public static String getCurrentDateTimeAsString() {
		return DATETIME_FORMAT.format(new Date());
	}

	public static String getCurrentDateTimeAsString(String pattern) {
		FastDateFormat formatter = FastDateFormat.getInstance(pattern);
		return formatter.format(new Date());
	}

	public static Date getStartDateTimeOfCurrentMonth() {
		return getStartDateTimeOfMonth(new Date());
	}

	/**
	 * The value of
	 * <ul>
	 * <li>Calendar.HOUR_OF_DAY
	 * <li>Calendar.MINUTE
	 * <li>Calendar.MINUTE
	 * </ul>
	 * will be set 0.
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartDateTimeOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date getEndDateTimeOfCurrentMonth() {
		return getEndDateTimeOfMonth(new Date());
	}

	public static Date getEndDateTimeOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date getStartTimeOfCurrentDate() {
		return getStartTimeOfDate(new Date());
	}

	public static Date getStartTimeOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * <tt>2005-12-27 17:58:56</tt> will be returned as
	 * <tt>2005-12-27 23:59:59</tt>
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndTimeOfCurrentDate() {
		return getEndTimeOfDate(new Date());
	}

	public static Date getEndTimeOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date addHours(Date date, int hours) {
		return add(date, Calendar.HOUR_OF_DAY, hours);
	}

	public static Date addMinutes(Date date, int minutes) {
		return add(date, Calendar.MINUTE, minutes);
	}
	
	public static Date addSeconds(Date date, int seconds) {
		return add(date, Calendar.SECOND, seconds);
	}

	public static Date addDays(Date date, int days) {
		return add(date, Calendar.DATE, days);
	}

	/**
	 * Returns a new datetime adds the specified (signed) number of months.
	 * 
	 * @param date
	 *            the date subtract on
	 * @param months
	 *            the amount of months to subtract, may be negative
	 * @return the new Date minus the increased months
	 */
	public static Date addMonths(Date date, int months) {
		return add(date, Calendar.MONTH, months);
	}

	public static Date addYears(Date date, int years) {
		return add(date, Calendar.YEAR, years);
	}

	private static Date add(Date date, int field, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		return cal.getTime();
	}

	public static final int daysBetween(java.util.Date early,
			java.util.Date late) {
		Calendar ecal = Calendar.getInstance();
		Calendar lcal = Calendar.getInstance();
		ecal.setTime(early);
		lcal.setTime(late);

		long etime = ecal.getTimeInMillis();
		long ltime = lcal.getTimeInMillis();

		return (int) ((ltime - etime) / MILLIS_PER_DAY);
	}

	/**
	 * 两个时间间隔多少分
	 * @param early
	 * @param late
	 * @return
	 */
	public static final int minutesBetween(java.util.Date early,
			java.util.Date late) {
		Calendar ecal = Calendar.getInstance();
		Calendar lcal = Calendar.getInstance();
		ecal.setTime(early);
		lcal.setTime(late);
		long etime = ecal.getTimeInMillis();
		long ltime = lcal.getTimeInMillis();
		return (int) ((ltime - etime)/MILLIS_PER_MINUTE );
	}	
	
	/**
	 * 得到当前时间的yyyy-MM-dd HH:mm:ss格式化字符串
	 * @return
	 */
	public static String getNow() {
		String sCurTime = "";
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA);
			Calendar sNow = Calendar.getInstance();
			sCurTime = sdf.format(sNow.getTime());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sCurTime;
	}

	/**
	 * 验证字符串是否是合法的日期
	 * 
	 * @param str_date
	 * @return
	 */
	public static boolean is_valid_date_formate(String str_date) {
		if (str_date.length() > 10) {
			str_date = str_date.substring(1);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = sdf.parse(str_date);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	/**
	 * 验证字符串是否是合法的日期
	 * 
	 * @param str_date
	 * @return
	 */
	public static boolean is_valid_str_date_formate(String str_date) {
		boolean flag = false;
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (str_date.equals(date.format(date.parse(str_date)))) {
				flag = true;
			}
		} catch (ParseException e) {
		}
		return flag;
	}

	/**
	 * 验证字符串是否是合法的日期
	 * 
	 * @param str_date
	 * @return
	 */
	public static boolean is_valid_str_dateTime_formate(String str_date) {
		boolean flag = false;
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if (str_date.equals(date.format(date.parse(str_date)))) {
				flag = true;
			}
		} catch (ParseException e) {
		}
		return flag;
	}

	/**
	 * 获取月序列 201004
	 * 
	 * @return
	 */
	public static String getCurrentYearMonth() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		if (month < 10) {
			return year + "0" + month;
		} else {
			return year + "" + month;
		}
	}
	
	/**
	 * 获取月序列 201004  -- 201005
	 * 
	 * @return
	 */
	public static String getCurrentYearMonthNext() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 2;
		if (month < 10) {
			return year + "0" + month;
		} else {
			return year + "" + month;
		}
	}	


	/**
	 * 比较两个日期
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static boolean compareTwoDate(String date1, String date2) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date ndate1 = null, ndate2 = null;
		try {
			ndate1 = (Date) format.parseObject(date1);
			ndate2 = (Date) format.parseObject(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (ndate1.after(ndate2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 比较两个日期間隔天數
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static Long getBetweenDays(String date1, String date2) {
		long days = new Long(0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ndate1 = null, ndate2 = null;
		try {
			ndate1 = (Date) format.parseObject(date1);
			ndate2 = (Date) format.parseObject(date2);
			Calendar beginCalendar = Calendar.getInstance();
			Calendar endCalendar = Calendar.getInstance();
			beginCalendar.setTime(ndate1);
			endCalendar.setTime(ndate2);
			// 计算天数
			while (beginCalendar.before(endCalendar)) {
				days++;
				beginCalendar.add(Calendar.DAY_OF_MONTH, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Long(days);
	}

	/**
	 * 判断是否为闰年
	 * @param args
	 */
	
	public static boolean isLeapYear(int year){
		if(year%4==0 && year%100!=0 || year%400==0){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(DateUtils.getBetweenDays("2010-04-15 09:17:29",
				"2011-05-16 19:17:29"));
	}
}
