package models;

import views.*;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import controllers.*;
import objects.*;

public class Model {
	private Controller controller;
	private View view;
	
	private ArrayList<Lecturers> list;
	
	//Lecturers obj = new Lecturers(String lecturerID, lecturerName, lecturerAddress, lecturerPhone, lecturerEmail, lecturerType);
	
	/*public <T> void write(String filename, ArrayList<T> arrayList) {
		
	}*/
	
	public void write() throws IOException {
		System.out.println("Writing objects (lecturers.dat and departments.dat)");
		
		try {
			FileInputStream lecturersFile = new FileInputStream("lecturers.dat");
			ObjectInputStream ois = new ObjectInputStream(lecturersFile);
			
			FileInputStream departmentsFile = new FileInputStream("departments.dat");
			ObjectInputStream ous = new ObjectInputStream(departmentsFile);
			lecturersFile.close();
			departmentsFile.close();
			//ObjectInputStream lecturersFile = new ObjectInputStream(new FileInputStream("lecturers.dat"));
			//ObjectInputStream departmentsFile = new ObjectInputStream(new FileInputStream("departments.dat"));
		} catch (Exception ex) {
			System.err.println("Failed to write file");
		}
	} // end of write()
		
	public void load() throws IOException {
		System.out.println("Loading objects");
		
		File lecturersFile = new File("lecturers.dat");
	    if(lecturersFile.exists())
	    {
	        try
	        {
	            FileInputStream fis = new FileInputStream(lecturersFile);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            Lecturers emp = null;
	            while((emp = (Lecturers) ois.readObject()) != null)
	            {
	                list.add(emp);
	            }
	        }
	        catch(Exception e){
	        	System.err.println("Failed to load file");
	        }
	    }
	} // end of load()
	
	public void addLecturers() throws IOException {
		
		try {
			
			
		/*Lecturers lecturersFile = new Lecturers(view.getIdText(),
				view.getNameText(),
				view.getAddressText(),
				view.getPhoneText(),
				view.getEmailText(),
				view.gethrTypeText());*/
		
		Lecturers lecturersFile = new Lecturers(view.getIdText().getText(),
				view.getNameText().getText(),
				view.getAddressText().getText(),
				view.getPhoneText().getText(),
				view.getEmailText().getText(),
				view.gethrTypeText().getText());
		
		//Lecturers lecturersFile = new Lecturers("1", "John", "Gold Street", "532514834", "john@john.com", "Full-Time");
		//Lecturers lecturersFile = new Lecturers(id, name, address, phone, email, type);
		FileOutputStream fos = new FileOutputStream("lecturers.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(lecturersFile);
		oos.close();
		
		FileInputStream fis = new FileInputStream("lecturers.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Lecturers obj = null;
	
		while ((obj = (Lecturers) ois.readObject()) != null) {
			System.out.println("Lecturer ID: " + obj.getlecturerID() 
			+ ", Lecturer Address: " + obj.getlecturerAddress() 
			+ ", Lecturer Phone No: " + obj.getlecturerPhone() 
			+ ", Lecturer Email: " + obj.getlecturerEmail() 
			+ ", Type: " + obj.getlecturerType());
		}
		ois.close();
		} catch (EOFException ex) {
			System.out.println("End of file reached.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			System.err.println("Failed to write file");
		}
	} // end of addLecturers()
	
	public void addDepartments() throws IOException {
		//departmentName, departmentID, departmentType;
		
		try {
		Departments departmentsFile = new Departments(1, "Chemistry", "Science");
		FileOutputStream fos = new FileOutputStream("departments.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(departmentsFile);
		oos.close();
		FileInputStream fis = new FileInputStream("departments.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Departments obj = null;
	
		while ((obj = (Departments) ois.readObject()) != null) {
			System.out.println("Department ID: " + obj.getdepartmentID() 
			+ ", Department Name: " + obj.getdepartmentName() 
			+ ", Type: " + obj.getdepartmentType());
		}
		ois.close();
		} catch (EOFException ex) {
			System.out.println("End of file reached.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			System.err.println("Failed to write file");
		}
	} // end of addDepartments()
		
	public void readDepartments() {
		
	}
	
	public void readLecturers() {
		
	}
	
	
	
}

