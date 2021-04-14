package com.bitacademy.myportal.vo;

import java.util.Date;

public class GuestbookVo {
	// field
	
	private Long no; // PK
	private String name;
	private String password;
	private String content;
	private Date regDate;
	
	// constructor
	// 기본 생성자는 필수
	public GuestbookVo() {
		
	}
	
	// 사용자 정의 (삭제할때 사용할 생성자)
	public GuestbookVo(Long no, String password) {
		this.no = no;
		this.password = password;
	}
	// 사용자 정의 (인서트용도 생성자)

	public GuestbookVo(String name, String password, String content) {
		super();
		this.name = name;
		this.password = password;
		this.content = content;
	}
	// 전체생성자

	public GuestbookVo(Long no, String name, String password, String content, Date regDate) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.regDate = regDate;
	}
	
	// Getter / Setter
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	//to string
	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
	
	
	
	
	
}
