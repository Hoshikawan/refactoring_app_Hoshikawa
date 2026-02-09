package jp.co.sss.crud.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
	
	private int empId;
	private String empName;
	private int gender;
	private LocalDate birthday;
	private String deptName;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	private String getGenderLabel() {
		if(gender == 0) {
			return "回答なし";
		} else if (gender == 1) {
			return "男性";
		} else if (gender == 2) {
			return "女性";
		} else if (gender == 9) {
			return "その他";
		} else {
			return "";
		}
	}
	
	private String getbirthdayFormat() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return birthday.format(formatter);
	}
	
	@Override
	public String toString() {
		return empId + "\t" + empName + "\t" + getGenderLabel() + "\t" + getbirthdayFormat() + "\t" + deptName;
	}
	
	
}
