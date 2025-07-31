package com.project.CRUDoperation;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;


@Entity
@Table(name = "student_table")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "studentId")
	private Long studentId;

	@Column(name = "studentName")
	private String studentName;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
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

	public Students(Long studentId, String studentName, String address, String email, String mobile, Date createdAt,
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

	public Students() {
		super();
	}

	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address + ", email="
				+ email + ", mobile=" + mobile + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
