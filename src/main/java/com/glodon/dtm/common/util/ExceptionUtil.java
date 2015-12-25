/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月24日 上午10:26:23
 */
package com.glodon.dtm.common.util;

public class ExceptionUtil {

	public static String getStackMsg(Exception e) {

		StringBuffer sb = new StringBuffer();
		StackTraceElement[] stackArray = e.getStackTrace();
		for (int i = 0; i < stackArray.length; i++) {
			StackTraceElement element = stackArray[i];
			sb.append(element.toString() + "\n");
		}
		return sb.toString();
	}

	public static String getStackMsg(Throwable e) {

		StringBuffer sb = new StringBuffer();
		StackTraceElement[] stackArray = e.getStackTrace();
		for (int i = 0; i < stackArray.length; i++) {
			StackTraceElement element = stackArray[i];
			sb.append(element.toString() + "\n");
		}
		return sb.toString();
	}
}
