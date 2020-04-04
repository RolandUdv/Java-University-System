package objects;

import java.io.Serializable;

public class Departments implements Serializable{
	private String departmentName, departmentType;
	private int departmentID;
	
	public Departments (int departmentID, String departmentName, String departmentType) {
		this.departmentName = departmentName;
		this.departmentID = departmentID;
		this.departmentType = departmentType;
	}
	
	// gets
	public int getdepartmentID() {
		return departmentID;
	}
	
	public String getdepartmentName() {
		return departmentName;
	}
	
	public String getdepartmentType() {
		return departmentType;
	}
	
	// sets
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	
	public void setdepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public void setdepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

}
