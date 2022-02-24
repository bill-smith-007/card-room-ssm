package com.itheima.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itheima.core.po.User;

public class Help {
	
	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	public static User local_user;
	
	
}
