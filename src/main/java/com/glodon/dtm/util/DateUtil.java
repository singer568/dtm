/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午4:45:37
 */
package com.glodon.dtm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Date getBeginDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		date = date.substring(0, date.indexOf(" ") + 1);
		date = date + " 00:00:00";

		Date beginDate = null;
		try {
			beginDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return beginDate;
	}

	public static Date getEndDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		date = date.substring(0, date.indexOf(" ") + 1);
		date = date + " 23:59:59";

		Date beginDate = null;
		try {
			beginDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return beginDate;
	}
}
