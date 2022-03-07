import java.util.Scanner;
public class Endereco {
	// Atributos
	private long cep;
	private String estado;
	private String cidade;
	private String logradouro;
	private String complemento;
	private int numero;
	private Scanner ler = new Scanner(System.in);// Para os metodos
	private char res;// Para confirmacao ao adicionar complemento
	// Metodo Construtor de Endereco
	public Endereco(long cep, String estado, String cidade, String logradouro, String complemento, int numero) {
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
	}
	// Getters e Setters 
	public long getCEP() {
		return cep;
	}
	public void setCEP(long cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	// Metodos
	public void cadastraEndereco() {
		System.out.println("Digite o CEP (apenas numeros):");
		setCEP(ler.nextLong());
		System.out.println("Digite o Estado:");
		setEstado(ler.nextLine());
		System.out.println("Digite a cidade:");
		setCidade(ler.nextLine());
		System.out.println("Digite a rua:");
		setLogradouro(ler.nextLine());
		System.out.println("Digite o numero da casa ou apto:");
		setNumero(ler.nextInt());
		do {
		System.out.println("Deseja adicionar complemento?(S/N)");
		res = ler.next().charAt(0);
		}while(res != 'S' && res != 'N');
		if(res == 'S') {
			System.out.println("Digite o complemento:");
			setComplemento(ler.nextLine());
		}
	}
}