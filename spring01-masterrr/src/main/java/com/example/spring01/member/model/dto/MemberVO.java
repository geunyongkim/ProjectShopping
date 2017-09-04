package com.example.spring01.member.model.dto;

import java.sql.Date;

public class MemberVO {
	
	private String n_mc;
	private String n_mon;
	private Date order_date;
	private String buyer_name;
	
	public String getN_mc() {
		return n_mc;
	}
	public void setN_mc(String n_mc) {
		this.n_mc = n_mc;
	}
	public String getN_mon() {
		return n_mon;
	}
	public void setN_mon(String n_mon) {
		this.n_mon = n_mon;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	

	
	
//	private String userId;
//	private String userPw;
//	private String userName; 
//	private String userEmail; 
//	private Date userRegdate; // java.sql.Date
//	private Date userUpdatedate;
//	
//	// Getter/Setter
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public String getUserPw() {
//		return userPw;
//	}
//	public void setUserPw(String userPw) {
//		this.userPw = userPw;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getUserEmail() {
//		return userEmail;
//	}
//	public void setUserEmail(String userEmail) {
//		this.userEmail = userEmail;
//	}
//	public Date getUserRegdate() {
//		return userRegdate;
//	}
//	public void setUserRegdate(Date userRegdate) {
//		this.userRegdate = userRegdate;
//	}
//	public Date getUserUpdatedate() {
//		return userUpdatedate;
//	}
//	public void setUserUpdatedate(Date userUpdatedate) {
//		this.userUpdatedate = userUpdatedate;
//	}
//	
//	// toString()
//	@Override
//	public String toString() {
//		return "MemberVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail="
//				+ userEmail + ", userRegdate=" + userRegdate + ", userUpdatedate=" + userUpdatedate + "]";
//	}
	
}
