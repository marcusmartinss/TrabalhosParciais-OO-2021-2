package controller;
import java.util.Scanner;

/**
 * 
 * Classe de Pessoa 
 * 
 * @author iagom, marcusmartinsxx
 * @version 4.00
 * @since Release 3 da aplicacao
 *
 */

public abstract class Pessoa extends Endereco{
	// Atributos
	private String nome;
	private String cpf;
	private String telefone;
	private Endereco endereco;// Para armazenar infos especificas do endereco
	private String rg;
	private Usuario usuario;// Para armazenar infos especificas do usuario
	private Scanner ler = new Scanner(System.in);// Para realizar os metodos
	private char res;
	/**
	 * 
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
	public Pessoa(String nome, String cpf, String telefone, String rg, long cep, String estado, String cidade, String logradouro, String complemento, int numero){
		super(cep, estado, cidade, logradouro, complemento, numero);
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rg = rg;
	}
	// Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	// Metodos
	/**
	 * Metodo que cadastra uma pessoa no sistema
	 * @param usuario - o usuario que sera cadastrado
	 */
	public void cadastraPessoa(Usuario[] usuario) {
		System.out.print("\nDigite seu nome:");
		setNome(ler.nextLine());
		System.out.print("Digite seu CPF:");
		setCpf(ler.nextLine());
		System.out.print("Digite seu telefone:");
		setTelefone(ler.nextLine());
		System.out.print("Digite o CEP (apenas numeros):");
		setCEP(ler.nextLong());
		ler.nextLine();
		System.out.print("Digite o Estado:");
		setEstado(ler.nextLine());
		System.out.print("Digite a cidade:");
		setCidade(ler.nextLine());
		System.out.print("Digite a rua:");
		setLogradouro(ler.nextLine());
		System.out.print("Digite o numero da casa ou apto:");
		setNumero(ler.nextInt());
		do {
		System.out.print("Deseja adicionar complemento?(S/N):");
		res = ler.next().charAt(0);
		}while(res != 'S' && res != 'N');
		if(res == 'S') {
			System.out.print("Digite o complemento:");
			ler.nextLine();
			setComplemento(ler.nextLine());
		}
		System.out.print("Digite seu RG:");
		ler.nextLine();
		setRg(ler.nextLine());
		//setUsuario(usuario);// Chama funcao que edita o usuario
	}
	/**
	 * Metodo que mostra a pessoa cadastrada
	 */
	public void visualizaPessoa() {
		System.out.println("Nome: " + getNome() + "\nCPF: " + getCpf() + "\nTelefone: " + getTelefone() + "\nEndereco - \nCEP: " + this.endereco.getCEP() + 
							"\nCidade: " + this.endereco.getCidade() + "\nComplemento: " + this.endereco.getComplemento() + "\nEstado: " + this.endereco.getEstado() +
							"\nRua: " + this.endereco.getLogradouro() + "\nNumero: " + this.endereco.getNumero()+ "\nRG: " + getRg() + "\nEmail: " + this.usuario.getEmail()
							+ "\nID: " + this.usuario.getId() );// Printa todas as infos da Pessoa
		System.out.println("\nPressione Enter para continuar...");
		ler.next();
	}
	/**
	 * Metodo que edita a pessoa cadastrada
	 */
	public void editaPessoa() {
		char opcao;
		
		System.out.println("\nO que deseja editar?");
		System.out.println("\n1 - Nome\n2 - Telefone\n3 - Endereco\n");
		opcao = ler.next().charAt(0);
		if( (int)opcao < 49 || (int)opcao > 53 ) {// Menu de escolha para o que editar dentro das infos editáveis
			System.out.println("\nNumero invalido.");
		}else {
			switch(opcao) {
				case '1':
					System.out.print("Digite seu nome:");
					ler.nextLine();
					setNome(ler.nextLine());
					System.out.println("Nome alterado com sucesso.");
					break;
				case '2':
					System.out.print("Digite seu novo telefone:");
					ler.nextLine();
					setTelefone(ler.nextLine());
					System.out.println("Telefone alterado com sucesso.");
					break;
				case '3':
					setEndereco(endereco);
					System.out.println("Endereco alterado com sucesso.");
					break;
			}
		}
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
	/**
	 * Metodo que deleta a pessoa do sistema
	 */
	public void deletaPessoa() {
		setCpf(null);
		setNome(null);
		setEndereco(null);
		setRg(null);
		setTelefone(null);
		
		System.out.println("\nUsuario deletado com sucesso.");
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
}
