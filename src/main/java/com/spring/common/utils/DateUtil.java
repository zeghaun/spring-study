package com.spring.common.utils;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * 项目名称：账号安全中心(all)   
 * 类名称：DateUtil   
 * 类描述：   时间操作工具
 */
public class DateUtil {

	/**
	 * 生成ISO-8601 规范的时间格式
	 * @param date
	 * @return
	 */
	public static String formatISO8601DateString(Date date){
		String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		return DateFormatUtils.format(date, pattern);
	}
	
	/**
	 * 获取上周日日期对象
	 * 
	 * @param date
	 * @return
	 * @since
	 */
    public static Date getLastWeekSunday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.set(Calendar.DAY_OF_WEEK, 1);
        return cal.getTime();
    }
	
    /**
     * 获取本周一
     * 
     * @param date
     * @return
     * @since
     */
    public static Date getNowWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }
    
    /**
     * 获取上周一
     * 
     * @param date
     * @return
     * @since
     */
    public static Date getLastWeekMonday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, -1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }
	
}
