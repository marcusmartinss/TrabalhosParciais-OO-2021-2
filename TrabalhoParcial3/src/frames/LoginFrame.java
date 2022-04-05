package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener{

	Container container = getContentPane();
	JLabel userLabel = new JLabel("Usuario");
	JTextField UserText = new JTextField(20);
	JLabel passwordLabel = new JLabel("Senha");
	JPasswordField passwordText = new JPasswordField(20);
	JButton loginButton = new JButton("Login");
	JButton registerButton = new JButton("Registro");
	JCheckBox showPassword = new JCheckBox("Mostrar senha");
	
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
		userLabel.setBounds(10, 10, 80, 25);
		UserText.setBounds(100, 10, 160, 25);
		passwordLabel.setBounds(10, 40, 80, 25);
		passwordText.setBounds(100, 40, 160, 25);
		showPassword.setBounds(96, 70, 110, 20);
		loginButton.setBounds(10, 100, 100, 25);
		registerButton.setBounds(173, 100, 100, 25);
	}
	
	public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(UserText);
        container.add(passwordText);
        container.add(showPassword);
        container.add(loginButton);
        container.add(registerButton);
    }
	
	public void actionPerformed(ActionEvent e) { //Acoes ao interagir
		// Botao de mostrar senha
		if ( e.getSource() == showPassword ) {
			if ( showPassword.isSelected() ) {
				passwordText.setEchoChar((char) 0);
			}
			else {
				passwordText.setEchoChar('*');
			}
		}
		//Botao de login
		if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = UserText.getText();
            pwdText = passwordText.getText();
            if ( true ) { // integrar ArrayList do back com front
                JOptionPane.showMessageDialog(this, "Login realizado!");
            } else {
                JOptionPane.showMessageDialog(this, "Os dados nao foram encontrados");
            }
 
        }
        //Botao de registro
        if (e.getSource() == registerButton) {
            // colocar tela de registro
        }

	}
	
	public void addActionEvent() {
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
	
	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setTitle("Login");
		loginFrame.setVisible(true);
		loginFrame.setSize(300, 175);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
	}
}