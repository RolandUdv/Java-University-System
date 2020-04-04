package objects;

import java.io.Serializable;

public class Lecturers implements Serializable {

	private String lecturerID, lecturerName, lecturerAddress, lecturerEmail, lecturerType, lecturerPhone;
	
	public Lecturers (String lecturerID, String lecturerName, String lecturerAddress, String lecturerPhone, String lecturerEmail, String lecturerType) {
		this.lecturerID = lecturerID;
		this.lecturerName = lecturerName;
		this.lecturerAddress = lecturerAddress;
		this.lecturerPhone = lecturerPhone;
		this.lecturerEmail = lecturerEmail;
		this.lecturerType = lecturerType;
		
	}

	// gets
	public String getlecturerID() {
		return lecturerID;
	}

	public String getlecturerName() {
		return lecturerName;
	}
	
	public String getlecturerAddress() {
		return lecturerAddress;
	}
	
	public String getlecturerPhone() {
		return lecturerPhone;
	}
	
	public String getlecturerEmail() {
		return lecturerEmail;
	}
	
	public String getlecturerType() {
		return lecturerType;
	}

	// sets
	public void setlecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}

	public void setlecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	
	public void setlecturerAddress(String lecturerAddress) {
		this.lecturerAddress = lecturerAddress;
	}
	
	public void setlecturerPhone(String lecturerPhone) {
		this.lecturerPhone = lecturerPhone;
	}
	
	public void setlecturerEmail(String lecturerEmail) {
		this.lecturerEmail = lecturerEmail;
	}

	public void setlecturerType(String lecturerType) {
		this.lecturerType = lecturerType;
	}
	
	@Override
	public String toString() {
		return "Lecturer ID: " + getlecturerID() 
		+ ", Lecturer Address: " + getlecturerAddress() 
		+ ", Lecturer Phone No: " + getlecturerPhone() 
		+ ", Lecturer Email: " + getlecturerEmail() 
		+ ", Type: " + getlecturerType();
	}
	
}
