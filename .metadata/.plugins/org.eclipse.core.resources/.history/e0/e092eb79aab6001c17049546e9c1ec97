import java.util.Scanner;

public class PitStop extends Endereco{
	// Atributos
	private Endereco endereco;
	private int qtdMaxBicicletas;
	private int qtdAtualBicicletas;
	private char res;
	private Scanner ler = new Scanner(System.in);// Para os metodos
	// Metodo Construtor de PitStop
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
		do {
		System.out.print("Deseja adicionar complemento?(S/N):");
		res = ler.next().charAt(0);
		}while(res != 'S' && res != 'N');
		if(res == 'S') {
			System.out.print("Digite o complemento:");
			ler.nextLine();
			setComplemento(ler.nextLine());
		}
		System.out.print("Digite a quantidade maxima de bicicletas que existirá nesse pitstop:");
		setQtdMaxBicicletas(ler.nextInt());
		setQtdAtualBicicletas(0);
		System.out.println("\nPitStop cadastrado com sucesso.");
	}
	public void visualizaPitStop() {
		System.out.println("Endereco do PitStop: \nCEP: " + this.endereco.getCEP() + "\nCidade: " + this.endereco.getCidade() + 
						   "\nComplemento: " + this.endereco.getComplemento() + "\nEstado: " + this.endereco.getEstado() + 
						   "\nRua: " + this.endereco.getLogradouro() + "\nNumero: " + this.endereco.getNumero() + 
						   "\nQuantidade Maxima de Bicicletas: " + this.qtdMaxBicicletas + "\nQuantidade Atual de Bicicletas: "
						   + this.qtdAtualBicicletas);
	}
	public void buscaPitStop() {
		this.endereco.getCidade();
		
	}
	public void deletaPitStop() {
		setEndereco(null);
		setQtdAtualBicicletas(0);
		setQtdMaxBicicletas(0);
		System.out.println("\nPitStop deletado com sucesso.");
	}
	public void cadastraBicicleta() {// Cadastra uma bicicleta no PitStop, se for possivel
		if(getQtdMaxBicicletas() > getQtdAtualBicicletas()) {
			setQtdAtualBicicletas(getQtdAtualBicicletas()+1);
			System.out.println("Bicicleta cadastrada com sucesso.");
		}else
			System.out.println("\nO numero maximo de bicicletas foi atingido.");
	}
	public void retiraBicicleta() {
		if(getQtdAtualBicicletas() > 0) {
			setQtdAtualBicicletas(getQtdAtualBicicletas() - 1);
		}else
			System.out.println("\nNao existem bicicletas nesse pitstop.");
	}
}