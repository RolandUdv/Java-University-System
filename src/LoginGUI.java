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

abstract class LoginGUI extends JFrame implements ActionListener, WindowListener {
	
	JFrame loginFrame;
	JPanel loginPanel, topPanel, bottomPanel;
	JLabel headerLabel, topLabel;
	JLabel statusLabel;
	JButton loginButton, exitButtonJ, resetButton;
	JRadioButton radioHR, radioSecretary;
	JTextField userText;
	JPasswordField passwordText;
	
	LoginGUI(String title) {
		super(title);
		loginFrame.setLocationRelativeTo(null); 
		loginFrame.setResizable(false);
		createLoginPage();
		setVisible(true);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void createLoginPage() {
		createFrame();
		createPanel();
		createTop();
		createHeader();
		createLogin();
		createBottom();
	}

	private void createPanel() {
		loginPanel = new JPanel();
		loginPanel.setLayout(new FlowLayout());
		loginPanel.setSize(new Dimension(600, 500));
		loginPanel.setBackground(Color.YELLOW);
		loginPanel.setVisible(true);
        add(loginPanel);
	}

	private void createFrame() {
		loginFrame = new JFrame("Log In to Northampton Metropolitan University Human Resources System");
		loginFrame.setSize(600, 500);
		loginFrame.setLayout(new GridLayout(5, 1));
		loginFrame.setLocationRelativeTo(null); // align in center
		loginFrame.setResizable(false); // not resizeable
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setVisible(true);
		loginPanel.add(loginFrame);
		
	}
	
	private void createHeader() {
		headerLabel.setText("Northampton Metropolitan University Login");
		loginFrame.add(headerLabel);
		topLabel.setText("Select to Sign in!");
	}
	
	private void createLogin() {
		JLabel nameLabel = new JLabel("User ID:", JLabel.RIGHT);
		JLabel passwordLabel = new JLabel("Password", JLabel.CENTER);
		JTextField userText = new JTextField(6);
		JPasswordField passwordText = new JPasswordField(6);

		radioHR = new JRadioButton("Human Resources Staff");
		topPanel.add(radioHR);
        
        radioSecretary = new JRadioButton("Secretary");
        topPanel.add(radioSecretary);

        ButtonGroup groupRadio = new ButtonGroup();
        groupRadio.add(radioHR);
        groupRadio.add(radioSecretary);
        
		JButton loginButton = new JButton("Login");
		loginButton.setPreferredSize(new Dimension(80, 30));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "Username: " + userText.getText();
				data += " Password: " + new String(passwordText.getPassword());
				System.out.println("Login button pressed");
			}
		});
		
		JButton resetButton = new JButton("Reset Fields");
		resetButton.setPreferredSize(new Dimension(110, 30));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userText.setText(null);
				passwordText.setText(null);
				System.out.println("Username and Password fields have been reset");
			}
		});
		
		JButton exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension(80, 30));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Reference -
				// https://stackoverflow.com/questions/21330682/confirmation-before-press-yes-to-exit-program-in-java
				int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",
						"System", JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					System.out.println("Application closed");
					loginFrame.dispose();
					System.exit(0);
				}
			}
		});
		
		loginPanel.add(nameLabel);
		loginPanel.add(userText);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordText);
		loginPanel.add(loginButton);
		
		bottomPanel.add(resetButton);
		bottomPanel.add(exitButton);

		loginFrame.setVisible(true);
		System.out.println("Application opened");
	}
	
	private void createTop() {
		topLabel = new JLabel("", JLabel.CENTER);
		loginFrame.add(topLabel);
	}
	
	private void createBottom() {
		bottomPanel= new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		loginFrame.add(bottomPanel);
	}

	
}