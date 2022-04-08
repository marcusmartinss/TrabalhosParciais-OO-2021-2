package controller;
import java.util.Scanner;
/**
 * 
 * Classe de usuario 
 * 
 * @author iagom, marcusmartinsxx
 * @version 4.00
 * @since Release 3 da aplicacao
 *
 */
public class Usuario extends Pessoa{
	// Atributos
	private String id;
	private String email;
	private String senha;
	private Scanner ler = new Scanner(System.in);// Para os metodos
	
	/**
	 * Metodo construtor de usuario
	 * 
	 * @param id - o id do usuario
	 * @param email - o email do usuario
	 * @param senha - a senha do usuario
	 * @param nome - o nome do usuario
	 * @param cpf - o cpf do usuario
	 * @param telefone - o telefone do usuario
	 * @param rg - o rg do usuario
	 * @param cep - o cep do usuario
	 * @param estado - o estado do usuario
	 * @param cidade - a cidade do usuario
	 * @param logradouro - a rua do usuario
	 * @param complemento - complemento adicionado ao endereco se necessario
	 * @param numero - numero do endereco do usuario
	 */
	public Usuario(String id, String email, String senha, String nome, String cpf, String telefone, String rg, long cep, String estado, String cidade, String logradouro, String complemento, int numero) {
		super(nome, cpf, telefone, rg, cep, estado, cidade, logradouro, complemento, numero);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setTelefone(telefone);
		this.setRg(rg);
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	// Getters e Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	// Metodos
	/**
	 * Metodo que cadastra o usuario
	 * @param usuario - todas as infos dentro do objeto Usuario
	 */
	public void cadastraUsuario(Usuario[] usuario) {
		this.cadastraPessoa(usuario);
		String tempSenha1, tempSenha2, tempEmail;
		int i;
		long tempID;
		boolean  existe;
		
		do {
			System.out.print("Digite seu e-mail: ");
			tempEmail = ler.nextLine();		
			if(tempEmail.length() == 0) {
				System.out.println("	O e-mail inserido eh nulo.\n");
			}
			else
			{
				if( !tempEmail.contains("@") ) {
					System.out.println("	Este e-mail nao possui um dominio.\n");
				}
			}
		} while( tempEmail.length() == 0 || !tempEmail.contains("@") );
		
		do {// Verifica senha
			System.out.print("Digite sua senha: ");
			tempSenha1 = ler.nextLine();
			System.out.print("Confirme a senha: ");
			tempSenha2 = ler.nextLine();
			if(!tempSenha1.equals(tempSenha2)) {
				System.out.println("Senhas nao coincidem. Tente novamente\n");
			}
			else
			{
				if( tempSenha1.length() == 0 )
				{
					System.out.println("Senhas nulas. Tente novamente\n");
				}				
			}
		}while( (!tempSenha1.equals(tempSenha2)) || (tempSenha1.length() == 0) );
		
		System.out.println("\nUsuario cadastrado com sucesso!");
		this.setSenha(tempSenha1);
		this.setEmail(tempEmail);
	}
	/**
	 * Metodo que edita as infos do usuario
	 */
	public void editaUsuario() {
		char opcao;
		String tempEmail, tempSenha;
		
		System.out.println("\nO que deseja editar?");
		System.out.println("\n1- E-mail\n2- Senha");
		opcao = ler.next().charAt(0);
		if( (int)opcao < 49 || (int)opcao > 51 ) {// Menu de escolha para o que editar dentro das infos editáveis
			System.out.println("\nNumero invalido.");
		}else {
			switch(opcao) {
				case '1':
					do {
						System.out.print("Digite o novo e-mail: ");
						ler.nextLine();
						tempEmail = ler.nextLine();		
						if(tempEmail.length() == 0) {
							System.out.println("	O e-mail inserido eh nulo.\n");
						}
						else
						{
							if( !tempEmail.contains("@") ) {
								System.out.println("	Este e-mail nao possui um dominio.\n");
							}
						}
					} while( tempEmail.length() == 0 || !tempEmail.contains("@") );
					this.setEmail(tempEmail);
					System.out.println("E-mail alterado com sucesso.");
					break;
				case '2':
					do {// Verifica senha
						System.out.print("Digite a nova senha: ");
						ler.nextLine();
						this.setSenha(ler.nextLine());
						System.out.print("Confirme a senha: ");
						tempSenha = ler.nextLine();
						if(!tempSenha.equals(this.getSenha())) {
							System.out.println("Senhas nao coincidem. Tente novamente\n");
						}
					}while(!tempSenha.equals(this.getSenha()));
					setSenha(tempSenha);
					System.out.println("Senha alterada com sucesso.");
					break;
			}
		}
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
}
