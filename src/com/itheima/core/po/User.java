package com.itheima.core.po;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 客户持久化类
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer Q_id;
	private String Q_nickname;
	private String Q_pwd;
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

	private Integer Q_root;
	private String Q_introduce;
	private String Q_phone;
	private Integer Q_sex;
	private Long Q_data;
	
	private Integer start;            // 起始行
	private Integer rows;             // 所取行数
	
	public User() {
		//id=0;
		Q_data=0L;
	}
	/*
	 * 
	 * public String getEnrolldateStr() {
		if(enrolldate>0) {
			SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
			return datef.format(new Date(enrolldate));
		}
		return "";
	}
	public void setEnrolldate(String enrolldate) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.enrolldate=dateFormat.parse(enrolldate).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.enrolldate=System.currentTimeMillis();
		}
	 * */
	public void setdata(String data) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.Q_data=dateFormat.parse(data).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.Q_data=System.currentTimeMillis();
		}
	}
	public String getDataStr() {
		if(Q_data>0) {
			SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
			return datef.format(new Date(Q_data));
		}
		return "";
	}


	public Long getData() {
		return Q_data;
	}
	public void setData(Long data) {
		this.Q_data = data;
	}
	public void setData(String data) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.Q_data=dateFormat.parse(data).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			this.Q_data=System.currentTimeMillis();
		}
	}
	
	
	public Integer getId() {
		return Q_id;
	}
	public void setId(Integer id) {
		this.Q_id = id;
	}
	public String getNickname() {
		return Q_nickname;
	}
	public void setNickname(String nickname) {
		this.Q_nickname = nickname;
	}
	public String getPassword() {
		return Q_pwd;
	}
	public void setPassword(String password) {
		this.Q_pwd = password;
	}

	public String getRootStr() {
		if(Q_root==1)
			return "管理员";
		else
			return "用户";
	}
	
	public Integer getRoot() {
		return Q_root;
	}
	public void setRoot(Integer root) {
		this.Q_root = root;
	}
	public String getIntroduce() {
		return Q_introduce;
	}
	public void setIntroduce(String introduce) {
		this.Q_introduce = introduce;
	}
	public String getPhone() {
		return Q_phone;
	}
	public void setPhone(String phone) {
		this.Q_phone = phone;
	}
	
	public String getSexStr() {
		if(Q_sex==0)
			return "男";
		else
			return "女";
	}
	public Integer getSex() {
		return Q_sex;
	}
	
	public void setSex(Integer sex) {
		this.Q_sex = sex;
	}
	

}
