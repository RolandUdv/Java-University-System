
/**********************************************************
* Program:	Assignment: Human Resource System			  *
* Filename:	SystemLogin.java							  *
* @author:	Roland Udvarlaki (17439891)					  *
* Course:	BSc Software Engineering Year 2				  *
* Module:	CSY2030 University Human Resource System	  *
* Tutor: 												  *	
* @version:	1.0											  *
* Date:		22/03/2019
* Github:												  *
***********************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class SystemLogin extends LoginGUI {
	
	SystemLogin(String title) {
		super(title);
	}
	
	/*public SystemLogin(String title) {
		System.out.print("hi");
		//createLoginPage();
	}*/

	private void checkCredits() {
		String username = userText.getText();
		String password = new String(passwordText.getPassword());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*if (arg0.getSource()  == loginButton){
			createLoginPage();
			pack();
		}*/
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("App closed");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
