package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginFrame extends JFrame implements ActionListener{

	Container container = getContentPane(); // Criacao do container
	JLabel userLabel = new JLabel("Usuario"); // Texto "Usuario"
	JTextField userText = new JTextField(20); // Espaco para adicionar texto, 20 caracteres max
	JLabel passwordLabel = new JLabel("Senha"); // Texto "Senha"
	JPasswordField passwordText = new JPasswordField(20); // Espaco para adicionar senha, ja fica em asterisco, 20 caracteres max
	JButton loginButton = new JButton("Login"); // Botao escrito "Login" dentro
	JButton registerButton = new JButton("Registro"); // Botao escrito "Registro" dentro
	JCheckBox showPassword = new JCheckBox("Mostrar senha"); // Quadrado de checagem com "Mostrar senha" ao lado
	
	LoginFrame() { // Metodo para montagem e interacao do frame de login
		setLayoutManager(); // permite posicionar livremente
		setLocationAndSize(); // define local e tamanho
        addComponentsToContainer(); // adiciona a janela (container)
        addActionEvent(); // gerencia a interatividade
	}
	
	public void setLayoutManager() {
        container.setLayout(null); // setando o layout do container como null
    }                              // conseguimos colocar a posicao no que quisermos
	
	public void setLocationAndSize() {
	//  dentro do parenteses se organiza como:
	// (posicao x na janela, posicao y na janela, largura em px, altura em px)
		userLabel.setBounds(10, 10, 80, 25); 
		userText.setBounds(100, 10, 160, 25); 
		passwordLabel.setBounds(10, 40, 80, 25);
		passwordText.setBounds(100, 40, 160, 25);
		showPassword.setBounds(96, 70, 110, 20); // largura e altura aqui sao mais um "safespace" para o texto, nao sei porque
		loginButton.setBounds(10, 100, 100, 25);
		registerButton.setBounds(173, 100, 100, 25);
	}
	
	public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userText);
        container.add(passwordText);
        container.add(showPassword);
        container.add(loginButton);
        container.add(registerButton);
    }
	
	public void actionPerformed(ActionEvent e) { //Acoes ao interagir
		// Botao de mostrar senha
		if ( e.getSource() == showPassword ) { // se o evento ocorrido for no checkbox de mostrar
			if ( showPassword.isSelected() ) { // a senha ele vai transformar os asteriscos de senha 
				passwordText.setEchoChar((char) 0); // em caracteres legiveis
			}
			else { //se nao, vai continuar ou mudar para asterisco de novo
				passwordText.setEchoChar('*');
			}
		}
		//Botao de login
		if (e.getSource() == loginButton) { // se o evento ocorrido for no botao de login
            String UserText;                
            String pwdText;
            UserText = userText.getText(); // vai pegar o texto no campo de texto de login e senha
            pwdText = passwordText.getText(); // e comparar, setei como true so como exemplo, mas tem que
            if ( true ) { // integrar ArrayList do back com front
                JOptionPane.showMessageDialog(this, "Login realizado!"); // mostra uma janela nova com "ok" dizendo isso
            } else {
                JOptionPane.showMessageDialog(this, "Os dados nao foram encontrados");
            }
 
        }
        //Botao de registro
        if (e.getSource() == registerButton) { // se a acao for no botao de cadastro
            // colocar tela de registro
        	// registerFrame.setVisible(true);
        }

	}
	
	public void addActionEvent() { // metodo que faz a acao que foi o "ouvida" na interacao
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
	
	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame(); // cria a janela
		loginFrame.setTitle("Login"); // define o nome da janela
		loginFrame.setVisible(true);  // deixa ela visivel
		loginFrame.setSize(300, 175); // largura e altura da janela
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quando fechar a janela, fecha o programa
		loginFrame.setResizable(false); // nao deixa redefinir o tamanho da janela
	}
}
