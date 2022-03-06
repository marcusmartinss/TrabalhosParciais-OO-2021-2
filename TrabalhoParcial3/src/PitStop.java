
public class PitStop {
	// Atributos
	private Endereco endereco;
	private int qtdMaxBicicletas;
	private int qtdAtualBicicletas;
	// Metodo Construtor de PitStop
	public PitStop(Endereco endereco, int qtdMaxBicicletas, int qtdAtualBicicletas) {
		super();
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
	public void cadastrar() {
		
	}
	public void visualizar() {
		
	}
	public void buscar() {
		
	}
	public void deletar() {
		
	}
	public void cadastrarBicicleta() {
		if(getQtdMaxBicicletas() > getQtdAtualBicicletas()) {
			setQtdAtualBicicletas(getQtdAtualBicicletas()+1);
		}else
			System.out.println("O numero maximo de bicicletas foi atingido");
	}
}
