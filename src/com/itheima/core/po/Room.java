package com.itheima.core.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Room {
	private Integer R_id;
	private String R_class;
	private String R_introduce;
	private Integer R_price;
	private Integer R_state;
	private Long R_data;
	
	private Integer start;            // 起始行
	private Integer rows; 			// 所取行数
	
public Room() {
	R_data=0L;
	// TODO Auto-generated constructor stub
}
	public String getStateStr() {
		if(R_state==1)
			return "已出租";
		else
			return "未出租";
	}
	public String getdataStr() {
		if(R_data !=null && R_data>0) {
			SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
			return datef.format(new Date(R_data));
		}
		return "";
	}
	public void setdata(String data) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.R_data=dateFormat.parse(data).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.R_data=System.currentTimeMillis();
		}
	}
	
	public Integer getR_id() {
		return R_id;
	}
	public void setR_id(Integer r_id) {
		R_id = r_id;
	}
	public String getR_class() {
		return R_class;
	}
	public void setR_class(String r_class) {
		R_class = r_class;
	}
	public String getR_introduce() {
		return R_introduce;
	}
	public void setR_introduce(String r_introduce) {
		R_introduce = r_introduce;
	}
	
	public Integer getR_price() {
		return R_price;
	}
	public void setR_price(Integer r_price) {
		R_price = r_price;
	}
	public Integer getR_state() {
		return R_state;
	}
	public void setR_state(Integer r_state) {
		R_state = r_state;
	}
	public Long getR_data() {
		return R_data;
	}
	public void setR_data(Long r_data) {
		R_data = r_data;
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
