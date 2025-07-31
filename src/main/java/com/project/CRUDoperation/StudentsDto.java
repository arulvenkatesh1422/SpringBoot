package com.project.CRUDoperation;

import java.util.Date;

public class StudentsDto {

	private Long studentId;
	private String studentName;
	private String address;
	private String email;
	private String mobile;
	private Date createdAt;
	private Date updatedAt;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public StudentsDto(Long studentId, String studentName, String address, String email, String mobile, Date createdAt,
			Date updatedAt) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public StudentsDto() {
		super();
	}

	@Override
	public String toString() {
		return "StudentsDto [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address
				+ ", email=" + email + ", mobile=" + mobile + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}

}
