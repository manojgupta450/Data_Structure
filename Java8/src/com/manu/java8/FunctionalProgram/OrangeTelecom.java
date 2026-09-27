package com.manu.java8.FunctionalProgram;

public class OrangeTelecom {
	
	public static OrangeTelecom create(String s) {
		String[] str = s.split(",");
		
			state=str[0];
			account_Length=str[1];
			are_code =str[2];
			phone =str[3];
			intl_plan=str[4];
			voice_mail=str[5];
			churned=str[20];
			
		return new OrangeTelecom(state,account_Length,are_code,phone,intl_plan,voice_mail,churned);
		
	}

	static String state;
	static String account_Length;
	static String are_code;
	static String phone;
	static String intl_plan;
	static String voice_mail;
	static String churned;
	
	
	public OrangeTelecom(String state, String account_Length, String are_code, String phone, String intl_plan,
			String voice_mail, String churned) {
		super();
		this.state = state;
		this.account_Length = account_Length;
		this.are_code = are_code;
		this.phone = phone;
		this.intl_plan = intl_plan;
		this.voice_mail = voice_mail;
		this.churned = churned;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAccount_Length() {
		return account_Length;
	}
	public void setAccount_Length(String account_Length) {
		this.account_Length = account_Length;
	}
	public String getAre_code() {
		return are_code;
	}
	public void setAre_code(String are_code) {
		this.are_code = are_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntl_plan() {
		return intl_plan;
	}
	public void setIntl_plan(String intl_plan) {
		this.intl_plan = intl_plan;
	}
	public String getVoice_mail() {
		return voice_mail;
	}
	public void setVoice_mail(String voice_mail) {
		this.voice_mail = voice_mail;
	}
	public String isChurned() {
		return churned;
	}
	public void setChurned(String churned) {
		this.churned = churned;
	}
	
	
}
