package com.itheima.core.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private Integer Q_id;
	
	private Double B_take;
	private Long B_time;
	private Long B_create;
	
	private Integer R_id;
	
	private Integer start;            // 起始行
	private Integer rows; 			// 所取行数
	
public Book() {
	B_time=0L;
	B_create=0L;
	// TODO Auto-generated constructor stub
}
public Integer getQ_id() {
	return Q_id;
}


public void setQ_id(Integer q_id) {
	Q_id = q_id;
}


public Double getB_take() {
	return B_take;
}


public void setB_take(Double b_take) {
	B_take = b_take;
}




	public Integer getR_id() {
	return R_id;
}
public void setR_id(Integer r_id) {
	R_id = r_id;
}
	public String gettimeStr() {
		if(B_time !=null && B_time>0) {
			SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
			return datef.format(new Date(B_time));
		}
		return "";
	}
	public void settime(String data) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.B_time=dateFormat.parse(data).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.B_time=System.currentTimeMillis();
		}
	}
	public String getcreateStr() {
		if(B_create !=null && B_create>0) {
			SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
			return datef.format(new Date(B_create));
		}
		return "";
	}
	public void setcreate(String data) {
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.B_create=dateFormat.parse(data).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.B_create=System.currentTimeMillis();
		}
	}
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
}
