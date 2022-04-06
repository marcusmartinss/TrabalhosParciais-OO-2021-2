package frames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterFrame2 extends JFrame implements ActionListener {

	Container container = getContentPane(); // Janela de usuario
	JLabel userLabel = new JLabel("Usuário");  // estruturar
	JTextField userText = new JTextField(); // mudar os nomes
	JLabel emailLabel = new JLabel("Email");
	JTextField emailText = new JTextField();
	JLabel passwordLabel = new JLabel("Senha");
	JTextField passwordText = new JPasswordField(20);
	JLabel cpasswordLabel = new JLabel("Confirmar Senha");
	JTextField cpasswordText = new JPasswordField(20);
	JCheckBox showPassword = new JCheckBox("Mostrar senha");
	JButton finishButton = new JButton("Finalizar");
	JButton backButton = new JButton("Anterior");
	
	RegisterFrame2() {
		setLayoutManager();
		setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
	}
	
	public void setLayoutManager() {
        container.setLayout(null);
    }
	
	public void setLocationAndSize() {
		emailLabel.setBounds(10, 10, 80, 25); 
		emailText.setBounds(130, 10, 160, 25);
		userLabel.setBounds(10, 40, 80, 25); 
		userText.setBounds(130, 40, 160, 25);
		passwordLabel.setBounds(10, 70, 80, 25);
		passwordText.setBounds(130, 70, 160, 25);
		cpasswordLabel.setBounds(10, 100, 100, 25);
		cpasswordText.setBounds(130, 100, 160, 25);
		showPassword.setBounds(96, 130, 110, 20);
		backButton.setBounds(20, 170, 100, 25);
		finishButton.setBounds(217, 170, 100, 25);
		
	}
	
	public void addComponentsToContainer() {
		container.add(emailLabel);
		container.add(emailText);
		container.add(userLabel);
        container.add(userText);
        container.add(passwordLabel);
        container.add(passwordText);
        container.add(showPassword);
        container.add(cpasswordLabel);
        container.add(cpasswordText);
		container.add(backButton);
		container.add(finishButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void addActionEvent() {
		finishButton.addActionListener(this);
        backButton.addActionListener(this);
        showPassword.addActionListener(this);
	}
	
	public static void main(String[] args) {
		RegisterFrame2 registerFrame2 = new RegisterFrame2(); 
		registerFrame2.setTitle("Cadastro"); 
		registerFrame2.setVisible(true); 
		registerFrame2.setSize(350, 250); 
		registerFrame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		registerFrame2.setResizable(false);
	}

}
