package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.*;
import models.*;

public class View extends JFrame {

	//private Model model;
	//private Controller controller;

	// Login
	private JFrame loginFrame;
	private JPanel loginPanel, topPanel, bottomPanel;
	private JLabel passwordLabel, nameLabel, statusLabel, headerLabel, topLabel;
	private JButton loginButton, exitButton, resetButton;
	private JRadioButton radioHR, radioSecretary;
	private JTextField userText;
	private JPasswordField passwordText;
	private ButtonGroup groupRadio;

	private JPanel hrPanel;
	private JFrame hrFrame;
	private JFrame secFrame;
	private JPanel secPanel;
	private JButton exitSysButton;
	private JButton addDeptButton;
	private JButton changeDeptButton;
	private JButton deleteDeptButton;
	private JButton addLectButton;
	private JButton changeLectButton;
	private JButton deleteLecButton;
	private JPanel hrMainPanel;

	private JPanel hrLeftPanel;
	private JPanel hrTopPanel;
	private JButton dspfullButton;
	private JButton dsppartButton;
	private JButton dspcontractButton;
	private JPanel secTopPanel;

	private JPanel secLeftPanel;

	private JPanel secMainPanel;
	private JButton searchLecButton;
	private JButton goBackButton;
	
	//hr
	private JTextField nameText;
	private JTextField addressText;
	private JTextField phoneText;
	private JTextField emailText;
	private JTextField idText;
	private JTextField hrtypeText;
	
	private JLabel nameHRLabel;
	private JLabel addressHRLabel;
	private JLabel phoneHRLabel;
	private JLabel emailHRLabel;
	private JLabel idHRLabel;
	private JLabel typeHRLabel;
	private JButton addLecturerButton;
	private Model model;



	public View(Model model, Controller controller) {
		this.model = model;
		controller.addView(this);

		addWindowListener(controller);

		// login frame
		this.loginFrame = new JFrame("Log In to Northampton Metropolitan University Human Resources System");
		this.loginFrame.setSize(600, 500);
		this.loginFrame.setLayout(new GridLayout(5, 1));
		this.loginFrame.setLocationRelativeTo(null);
		this.loginFrame.setResizable(false);
		this.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// hr frame
		this.hrFrame = new JFrame("Human Resources System");
		this.hrFrame.setSize(600, 500);
		//this.hrFrame.setLayout(new GridLayout(5, 1));
		this.hrFrame.setLocationRelativeTo(null);
		this.hrFrame.setResizable(false);
		this.hrFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// secretary frame
		this.secFrame = new JFrame("Secretary System");
		this.secFrame.setSize(600, 500);
		//this.secFrame.setLayout(new GridLayout(5, 1));
		this.secFrame.setLocationRelativeTo(null);
		this.secFrame.setResizable(false);
		this.secFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// login panels
		this.loginPanel = new JPanel();
		this.loginPanel.setLayout(new FlowLayout());
		this.loginPanel.setSize(new Dimension(600, 500));
		//loginPanel.setBackground(Color.BLUE);
		
		this.bottomPanel = new JPanel();
		this.bottomPanel.setLayout(new FlowLayout());
		
		this.topPanel = new JPanel();
		
		// hr panels
		this.hrPanel = new JPanel();
		this.hrPanel.setLayout(new BorderLayout());
		this.hrPanel.setPreferredSize(new Dimension(600, 500));
		//this.hrPanel.setBackground(Color.BLUE);
		
		this.hrTopPanel = new JPanel();

		this.hrTopPanel.setLayout(new FlowLayout());
		this.hrTopPanel.setPreferredSize(new Dimension(600, 50));
		this.hrTopPanel.setBackground(Color.GRAY);
		
		this.hrLeftPanel = new JPanel();
		this.hrLeftPanel.setLayout(new FlowLayout());
		this.hrLeftPanel.setPreferredSize(new Dimension(175, 300));
		this.hrLeftPanel.setBackground(Color.GRAY);
		
		this.hrMainPanel = new JPanel();
		//this.hrMainPanel.setLayout(new FlowLayout());
		this.hrMainPanel.setLayout(new GridLayout(7, 2));
		this.hrMainPanel.setPreferredSize(new Dimension(415, 450));
		//this.hrMainPanel.setBackground(Color.ORANGE);
		
		// hr textfields and labels
		this.nameHRLabel = new JLabel("Name:", SwingConstants.CENTER);
		this.addressHRLabel = new JLabel("Address:", SwingConstants.CENTER);
		this.phoneHRLabel = new JLabel("Phone:", SwingConstants.CENTER);
		this.emailHRLabel = new JLabel("Email:", SwingConstants.CENTER);
		this.idHRLabel = new JLabel("ID:", SwingConstants.CENTER);
		this.typeHRLabel = new JLabel("Type:", SwingConstants.CENTER);
		
		this.setNameText(new JTextField());
		this.setAddressText(new JTextField());
		this.setPhoneText(new JTextField());
		this.setEmailText(new JTextField());
		this.setIdText(new JTextField());
		this.hrtypeText = new JTextField();
		
		// secretary panels
		this.secPanel = new JPanel();
		this.secPanel.setLayout(new BorderLayout());
		this.secPanel.setPreferredSize(new Dimension(600, 500));
		
		this.secTopPanel = new JPanel();
		this.secTopPanel.setLayout(new FlowLayout());
		this.secTopPanel.setPreferredSize(new Dimension(600, 50));
		this.secTopPanel.setBackground(Color.GRAY);
		
		this.secLeftPanel = new JPanel();
		this.secLeftPanel.setLayout(new FlowLayout());
		this.secLeftPanel.setPreferredSize(new Dimension(175, 300));
		this.secLeftPanel.setBackground(Color.GRAY);
		
		this.secMainPanel = new JPanel();
		this.secMainPanel.setLayout(new FlowLayout());
		this.secMainPanel.setPreferredSize(new Dimension(425, 450));
		//this.secMainPanel.setBackground(Color.GRAY);

		// login labels
		this.headerLabel = new JLabel("Northampton Metropolitan University Login", SwingConstants.CENTER);
		this.topLabel = new JLabel("", SwingConstants.CENTER);
		this.topLabel.setForeground(Color.red);

		this.nameLabel = new JLabel("User ID:", JLabel.RIGHT);
		this.passwordLabel = new JLabel("Password", JLabel.CENTER);
		
		// login textfields
		this.setUserText(new JTextField(6));
		this.setPasswordText(new JPasswordField(6));

		// login radio buttons
		this.radioHR = new JRadioButton("Human Resources Staff");
		this.radioSecretary = new JRadioButton("Secretary");

		// login group radio buttons
		this.setGroupRadio(new ButtonGroup());
		this.getGroupRadio().add(radioHR);
		this.getGroupRadio().add(radioSecretary);

		// login buttons
		this.loginButton = new JButton("Login");
		this.loginButton.setPreferredSize(new Dimension(80, 30));
		this.loginButton.setActionCommand("login");
		this.loginButton.addActionListener(controller);

		this.resetButton = new JButton("Reset Fields");
		this.resetButton.setPreferredSize(new Dimension(110, 30));
		this.resetButton.setActionCommand("reset");
		this.resetButton.addActionListener(controller);

		this.exitButton = new JButton("Exit");
		this.exitButton.setPreferredSize(new Dimension(80, 30));
		this.exitButton.setActionCommand("exit");
		this.exitButton.addActionListener(controller);
		
		// hr buttons
		this.exitSysButton = new JButton("Exit");
		this.exitSysButton.setPreferredSize(new Dimension(100, 30));
		this.exitSysButton.setActionCommand("exitsys");
		this.exitSysButton.addActionListener(controller);
		
		this.addDeptButton = new JButton("Add Deptartment");
		this.addDeptButton.setPreferredSize(new Dimension(150, 30));
		this.addDeptButton.setActionCommand("adddept");
		this.addDeptButton.addActionListener(controller);
		
		this.changeDeptButton = new JButton("Change Dept. details");
		this.changeDeptButton.setPreferredSize(new Dimension(170, 30));
		this.changeDeptButton.setActionCommand("changedept");
		this.changeDeptButton.addActionListener(controller);
		
		this.deleteDeptButton = new JButton("Delete Dept.");
		this.deleteDeptButton.setPreferredSize(new Dimension(170, 30));
		this.deleteDeptButton.setActionCommand("deletedept");
		this.deleteDeptButton.addActionListener(controller);
		
		this.addLectButton = new JButton("Add Lecturer");
		this.addLectButton.setPreferredSize(new Dimension(150, 30));
		this.addLectButton.setActionCommand("addlect");
		this.addLectButton.addActionListener(controller);
		
		this.changeLectButton = new JButton("Change Lecturer details");
		this.changeLectButton.setPreferredSize(new Dimension(170, 30));
		this.changeLectButton.setActionCommand("changelect");
		this.changeLectButton.addActionListener(controller);
		
		this.deleteLecButton = new JButton("Delete Lecturer");
		this.deleteLecButton.setPreferredSize(new Dimension(170, 30));
		this.deleteLecButton.setActionCommand("deletelect");
		this.deleteLecButton.addActionListener(controller);
		
		// sec buttons
		this.dspfullButton = new JButton("Full-time Lecturers");
		this.dspfullButton.setPreferredSize(new Dimension(170, 30));
		this.dspfullButton.setActionCommand("fulllec");
		this.dspfullButton.addActionListener(controller);
		
		this.dsppartButton = new JButton("Part-Time Lecturers");
		this.dsppartButton.setPreferredSize(new Dimension(170, 30));
		this.dsppartButton.setActionCommand("partlec");
		this.dsppartButton.addActionListener(controller);
		
		this.dspcontractButton = new JButton("Contract Lecturers");
		this.dspcontractButton.setPreferredSize(new Dimension(170, 30));
		this.dspcontractButton.setActionCommand("contractlec");
		this.dspcontractButton.addActionListener(controller);
		
		this.searchLecButton = new JButton("Search Lecturer");
		this.searchLecButton.setPreferredSize(new Dimension(170, 30));
		this.searchLecButton.setActionCommand("searchlec");
		this.searchLecButton.addActionListener(controller);
		
		this.goBackButton = new JButton("Go Back");
		this.goBackButton.setPreferredSize(new Dimension(100, 30));
		this.goBackButton.setActionCommand("goback");
		this.goBackButton.addActionListener(controller);
		
		this.addLecturerButton = new JButton("Add");
		this.addLecturerButton.setPreferredSize(new Dimension(100, 30));
		this.addLecturerButton.setActionCommand("addlectbtn");
		this.addLecturerButton.addActionListener(controller);
		
		// add and load login view
		this.loginFrame.add(headerLabel);
		this.loginFrame.add(topPanel);
		this.loginFrame.add(topLabel);
		this.loginFrame.add(loginPanel);
		this.loginFrame.add(bottomPanel);
		
		this.topPanel.add(radioSecretary);
		this.topPanel.add(radioHR);
		
		this.loginPanel.add(nameLabel);
		this.loginPanel.add(getUserText());
		this.loginPanel.add(passwordLabel);
		this.loginPanel.add(getPasswordText());
		this.loginPanel.add(loginButton);

		this.bottomPanel.add(resetButton);
		this.bottomPanel.add(exitButton);
		
		this.loginFrame.setVisible(true);	
	}
	
	public void refreshPanel() {
		this.hrFrame.revalidate();
		this.hrFrame.repaint();
		this.secFrame.revalidate();
		this.secFrame.repaint();
		this.hrMainPanel.revalidate();
		this.hrMainPanel.repaint();
		this.secMainPanel.revalidate();
		this.secMainPanel.repaint();
	}
	
	// Open HR frame
	public void openHR() {
		this.loginFrame.dispose();
		this.hrFrame.add(hrPanel);
		
		this.hrPanel.add(hrTopPanel, BorderLayout.NORTH);
		this.hrPanel.add(hrLeftPanel, BorderLayout.WEST);
		this.hrPanel.add(hrMainPanel, BorderLayout.EAST);
		this.hrTopPanel.add(goBackButton);
		this.hrTopPanel.add(addDeptButton);
		this.hrTopPanel.add(addLectButton);
		this.hrTopPanel.add(exitSysButton);
		
		this.hrLeftPanel.add(changeDeptButton);
		this.hrLeftPanel.add(deleteDeptButton);
		this.hrLeftPanel.add(changeLectButton);
		this.hrLeftPanel.add(deleteLecButton);
		
		this.hrFrame.setVisible(true);
	}
	
	// Open Secretary frame
	public void openSec() {
		//this.loginFrame.dispose();
		this.secFrame.add(secPanel);
		
		this.secPanel.add(secTopPanel, BorderLayout.NORTH);
		this.secPanel.add(secLeftPanel, BorderLayout.WEST);
		this.secPanel.add(secMainPanel, BorderLayout.EAST);
		
		this.secTopPanel.add(goBackButton);
		this.secTopPanel.add(searchLecButton);
		this.secTopPanel.add(exitSysButton);
		
		this.secLeftPanel.add(dspfullButton);
		this.secLeftPanel.add(dsppartButton);
		this.secLeftPanel.add(dspcontractButton);
		
		this.secFrame.setVisible(true);
	}
	
	public void goBack() {
		this.secFrame.dispose();
		this.hrFrame.dispose();
		this.loginFrame.setVisible(true);
		refreshPanel();
	}
	
	public void addLecturer() {
		System.out.println("Lecturer textfields added");
		this.hrMainPanel.add(idHRLabel);
		this.hrMainPanel.add(getIdText());
		this.hrMainPanel.add(nameHRLabel);
		this.hrMainPanel.add(getNameText());
		this.hrMainPanel.add(addressHRLabel);
		this.hrMainPanel.add(getAddressText());
		this.hrMainPanel.add(phoneHRLabel);
		this.hrMainPanel.add(getPhoneText());
		this.hrMainPanel.add(emailHRLabel);
		this.hrMainPanel.add(getEmailText());
		this.hrMainPanel.add(typeHRLabel);
		this.hrMainPanel.add(hrtypeText);
		this.hrMainPanel.add(addLecturerButton);
		refreshPanel();
	}
	
	public JFrame getLoginFrame() {
		return loginFrame;
	}
	
	public void setLoginFrame(JFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	
	// Getters and Setters
	// login panels
	public JPanel gettopPanel() {
		return topPanel;
	}
	
	public JPanel getloginPanel() {
		return loginPanel;
	}
	
	public JPanel getbottomPanel() {
		return bottomPanel;
	}
	
	// login textfields, radiobuttons
	public JTextField getUserText() {
		return userText;
	}

	public void setUserText(JTextField userText) {
		this.userText = userText;
	}
	
	public JPasswordField getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(JPasswordField passwordText) {
		this.passwordText = passwordText;
	}
	
	public ButtonGroup getGroupRadio() {
		return groupRadio;
	}

	public void setGroupRadio(ButtonGroup groupRadio) {
		this.groupRadio = groupRadio;
	}
	
	public JRadioButton getRadioHR() {
		return radioHR;
	}
	
	public void setRadioHR(JRadioButton radioHR) {
		this.radioHR = radioHR;
	}
	
	public JRadioButton getRadioSecretary() {
		return radioSecretary;
	}
	
	public void setgetRadioSecretary(JRadioButton radioSecretary) {
		this.radioSecretary = radioSecretary;
	}
	
	public JLabel getTopLabel() {
		return topLabel;
	}

	public void setTopLabel(JLabel topLabel) {
		this.topLabel = topLabel;
	}

	// HR
	public JPanel gethrPanel() {
		return hrPanel;
	}
	
	public void sethrPanel(JPanel hrPanel) {
		this.hrPanel = hrPanel;
	}
	
	public JFrame gethrFrame() {
		return hrFrame;
	}
	
	public void sethrFrame(JFrame hrFrame) {
		this.hrFrame = hrFrame;
	}
	
	// Sec
	public JPanel getSecPanel() {
		return secPanel;
	}
	
	public void setSecPanel(JPanel secPanel) {
		this.secPanel = secPanel;
	}
	
	public JFrame getSecFrame() {
		return secFrame;
	}
	
	public void setSecFrame(JFrame secFrame) {
		this.secFrame = secFrame;
	}

	public JTextField getIdText() {
		return idText;
	}

	public void setIdText(JTextField idText) {
		this.idText = idText;
	}

	public JTextField getNameText() {
		return nameText;
	}

	public void setNameText(JTextField nameText) {
		this.nameText = nameText;
	}

	public JTextField getAddressText() {
		return addressText;
	}

	public void setAddressText(JTextField addressText) {
		this.addressText = addressText;
	}

	public JTextField getPhoneText() {
		return phoneText;
	}

	public void setPhoneText(JTextField phoneText) {
		this.phoneText = phoneText;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public void setEmailText(JTextField emailText) {
		this.emailText = emailText;
	}
	
	
	public JTextField gethrTypeText() {
		return hrtypeText;
	}

	public void setTypeHRText(JTextField hrtypeText) {
		this.hrtypeText = hrtypeText;
	}
	
	
	
	
}
