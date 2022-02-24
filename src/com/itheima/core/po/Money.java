package com.itheima.core.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Money {
	private Integer Q_id;
	private Integer M_message;
	private Double M_take;
	private Double M_count;
	
	private Long M_time;
	private Integer M_state;
	
	
	private Integer R_id;
	
	private Integer start;            // 起始行
	private Integer rows; 			// 所取行数
	
public Money() {
	M_time=0L;
	// TODO Auto-generated constructor stub
}
public Integer getQ_id() {
	return Q_id;
}


public void setQ_id(Integer q_id) {
	Q_id = q_id;
}




	public Integer getM_message() {
	return M_message;
}
public void setM_message(Integer m_message) {
	M_message = m_message;
}
public Double getM_take() {
	return M_take;
}
public void setM_take(Double m_take) {
	M_take = m_take;
}
public Double getM_count() {
	return M_count;
}
public void setM_count(Double m_count) {
	M_count = m_count;
}
public Long getM_time() {
	return M_time;
}
public void setM_time(Long m_time) {
	M_time = m_time;
}
public Integer getM_state() {
	return M_state;
}
public void setM_state(Integer m_state) {
	M_state = m_state;
}
public String getstateStr() {
	if(M_state==1)
		return "已支付";
	else
		return "未支付";
}
	public Integer getR_id() {
	return R_id;
}
public void setR_id(Integer r_id) {
	R_id = r_id;
}
	public String gettimeStr() {
		if(M_time !=null && M_time>0) {
			SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
			return datef.format(new Date(M_time));
		}
		return "";
	}
	public void settime(String data) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.M_time=dateFormat.parse(data).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.M_time=System.currentTimeMillis();
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
