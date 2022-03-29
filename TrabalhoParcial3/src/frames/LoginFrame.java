package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Login");
		frame.setSize(300, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		
		frame.setVisible(true);
	}
	
	public static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel("Usuario");
		JTextField UserText = new JTextField(20);
		JLabel passwordLabel = new JLabel("Senha");
		JPasswordField passwordText = new JPasswordField(20);
		JButton loginButton = new JButton("Login");
		JButton registerButton = new JButton("Registro");
		JCheckBox showPassword = new JCheckBox("Mostrar senha");
		
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);
		
		UserText.setBounds(100, 10, 160, 25);
		panel.add(UserText);
		
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);
		
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);
		loginButton.setBounds(10, 100, 100, 25);
		panel.add(loginButton);
		
		registerButton.setBounds(173, 100, 100, 25);
		panel.add(registerButton);
		
		showPassword.setBounds(96, 70, 110, 20);
		panel.add(showPassword);
	}
	
	public void actionPerformed(ActionEvent e) {
		// login
		if ( e.getSource() == showPassword ) {
			if ( showPassword.isSelected() ) {
				passwordText.setEchoChar((char) 0);
			}
			else {
				passwordText.setEchoChar('*');
			}
		}
	}
	
	public void addActionEvent() {
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
	
}

/*
public class LoginFrame extends JFrame implements ActionListener {
	 
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
 
 
    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
 
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
 
 
        }
    }
 
	public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
	}
}*/