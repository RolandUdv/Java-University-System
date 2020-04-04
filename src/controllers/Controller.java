package controllers;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import views.*;
import models.*;
import objects.*;

public class Controller implements ActionListener, WindowListener, ItemListener {

	private Model model;
	private View view;

	public Controller(Model model) {
		this.model = model;
	}

	public void addView(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "login") {
			JTextField userText = view.getUserText();
			JPasswordField passwordText = view.getPasswordText();
			
			if (this.view.getRadioSecretary().isSelected()) { //signed in
				if (userText.getText().equals("s") && passwordText.getText().equals("s")) {
					System.out.println("Secretary - Successfully Signed In!");
					this.view.getTopLabel().setText(null);
					this.view.openSec();
				} else { // not signed in
					JOptionPane.showMessageDialog(null,
						    "Wrong username or Password!",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
					this.view.getTopLabel().setText("Wrong username or Password!");
					System.out.println("Wrong username or Password!");
				}
			} else { //HR signed in
				if (userText.getText().equals("h") && passwordText.getText().equals("h")) {
					System.out.println("HR - Successfully Signed In!");
					this.view.getTopLabel().setText(null);
					this.view.openHR();
				} else { // hr not signed in
					JOptionPane.showMessageDialog(null,
						    "Wrong username or Password!",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
					this.view.getTopLabel().setText("Wrong username or Password!");
					System.out.println("Wrong username or Password!");
				}
			}
		} // end if

		if (e.getActionCommand() == "reset") {
			this.view.getGroupRadio().clearSelection();
			this.view.getUserText().setText(null);
			this.view.getPasswordText().setText(null);
			this.view.getTopLabel().setText(null);
			System.out.println("Username and Password fields have been reset");
		}

		if (e.getActionCommand() == "exit") {
			System.out.println("Exit button pressed");
			int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",
					"System", JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION) {
				System.out.println("Application closed");
				System.exit(0);
			}
		}
		
		if (e.getActionCommand() == "exitsys") {
			System.out.println("Exit button pressed");
			int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",
					"System", JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION) {
				System.out.println("Application closed");
				// include write file here to save before exiting
				try {
					model.write();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		}
		
		if (e.getActionCommand() == "goback") {
			int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back to login page?\n"
					+ "Save your work before going back!",
					"System", JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION) {
				view.refreshPanel();
				view.goBack();
				
			}
		}
		
		if (e.getActionCommand() == "addlect") {
			System.out.println("Add Lecturer button pressed");
			view.addLecturer();
		}
		
		if (e.getActionCommand() == "addlectbtn") {
			System.out.println("Add button pressed");
			try {
				model.addLecturers();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} catch (Exception ex) {
				System.err.println("Failed to write file");
			}
		}
	
} //actionperformed
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
