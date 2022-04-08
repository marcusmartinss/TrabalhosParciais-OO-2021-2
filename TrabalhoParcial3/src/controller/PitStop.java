package controller;
import java.util.Scanner;

/**
 * 
 * Classe principal do programa de bicicletas compartilhadas
 * 
 * @author iagom, marcusmartinsxx
 * @version 4.00
 * @since Release 3 da aplicacao
 *
 */

public class PitStop extends Endereco{
	// Atributos
	private Endereco endereco;
	private int qtdMaxBicicletas;
	private int qtdAtualBicicletas;
	private Scanner ler = new Scanner(System.in);// Para os metodos
	/** 
	 * Metodo Construtor de PitStop
	 * 
	 * @param endereco - endereco do pitstop
	 * @param qtdMaxBicicletas - quantidade maxima de bicicletas
	 * que podem ser registradas em um pitstop
	 * @param qtdAtualBicicletas - quantidade atual de bicicletas
	 * cadastradas em um pitstop
	 * @param cep - o cep pertencente ao pitstop
	 * @param estado - o estado pertencente ao pitstop
	 * @param cidade - a cidade pertencente ao pitstop
	 * @param logradouro - a rua pertencente ao pitstop
	 * @param complemento - o complemento do pitstop, se existir
	 * @param numero - o numero pertecente ao pitstop
	 */
	public PitStop(Endereco endereco, int qtdMaxBicicletas, int qtdAtualBicicletas, long cep, String estado, String cidade, String logradouro, String complemento, int numero) {
		super(cep, estado, cidade, logradouro, complemento, numero);
		this.endereco = endereco;
		this.qtdMaxBicicletas = qtdMaxBicicletas;
		this.qtdAtualBicicletas = qtdAtualBicicletas;
	}
	// Getters e Setters
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getQtdMaxBicicletas() {
		return qtdMaxBicicletas;
	}
	public void setQtdMaxBicicletas(int qtdMaxBicicletas) {
		this.qtdMaxBicicletas = qtdMaxBicicletas;
	}
	public int getQtdAtualBicicletas() {
		return qtdAtualBicicletas;
	}
	public void setQtdAtualBicicletas(int qtdAtualBicicletas) {
		this.qtdAtualBicicletas = qtdAtualBicicletas;
	}
	// Metodos
	/**
	 * Metodo que cadastra um pitstop novo no sistema
	 */
	public void cadastraPitStop() {
		System.out.println("\nSiga as informações para cadastrar o endereco do pitstop:");
		System.out.print("Digite o Estado:");
		setEstado(ler.nextLine());
		System.out.print("Digite a cidade:");
		setCidade(ler.nextLine());
		System.out.print("Digite a rua:");
		setLogradouro(ler.nextLine());
		System.out.print("Digite o numero da casa ou apto:");
		setNumero(ler.nextInt());
		System.out.print("Digite a quantidade maxima de bicicletas que existirá nesse pitstop:");
		setQtdMaxBicicletas(ler.nextInt());
		setQtdAtualBicicletas(0);
		System.out.println("\nPitStop cadastrado com sucesso.");
	}
	/**
	 * Metodo que visualiza um pitstop cadastrado no sistema
	 */
	public void visualizaPitStop() {
		System.out.println("\nCidade: " + this.endereco.getCidade() + "\nEstado: " + this.endereco.getEstado() 
							+ "\nRua: " + this.endereco.getLogradouro() + "\nNumero: " + this.endereco.getNumero() 
							+ "\nQuantidade Maxima de Bicicletas: " + this.qtdMaxBicicletas + "\nQuantidade Atual de Bicicletas: "
							+ this.qtdAtualBicicletas);
	}
	/**
	 * Metodo que busca a cidade do pitstop para visualizacao
	 */
	public void buscaPitStop() {
		this.endereco.getCidade();
		
	}
	/**
	 * Metodo que deleta um pitstop do sistema
	 */
	public void deletaPitStop() {
		setEndereco(null);
		setQtdAtualBicicletas(0);
		setQtdMaxBicicletas(0);
		System.out.println("\nPitStop deletado com sucesso.");
	}
	/**
	 * Metodo que cadastra uma bicicleta no pitstop
	 */
	public void cadastraBicicleta() {// Cadastra uma bicicleta no PitStop, se for possivel
		if(getQtdMaxBicicletas() > getQtdAtualBicicletas()) {
			setQtdAtualBicicletas(getQtdAtualBicicletas()+1);
			System.out.println("Bicicleta cadastrada com sucesso.");
		}else
			System.out.println("\nO numero maximo de bicicletas foi atingido.");
	}
	/**
	 * Metodo que retira uma bicicleta do pitstop
	 */
	public void retiraBicicleta() {
		if(getQtdAtualBicicletas() > 0) {
			setQtdAtualBicicletas(getQtdAtualBicicletas() - 1);
		}else
			System.out.println("\nNao existem bicicletas nesse pitstop.");
	}
}
