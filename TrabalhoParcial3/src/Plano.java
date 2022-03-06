
public class Plano {
	// Atributos
	private String tipo;
	private String descricao;
	private Aluguel aluguel;
	private int qtdBicicletas;
	// Metodo Construtor de Plano
	public Plano(String tipo, String descricao, Aluguel aluguel, int qtdBicicletas) {
		super();
		this.tipo = tipo;
		this.descricao = descricao;
		this.aluguel = aluguel;
		this.qtdBicicletas = qtdBicicletas;
	}
	// Getters e Setters
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
	public int getQtdBicicletas() {
		return qtdBicicletas;
	}
	public void setQtdBicicletas(int qtdBicicletas) {
		this.qtdBicicletas = qtdBicicletas;
	}
	// Metodos
	public void cadastrar() {
		
	}
	public void visualizar() {
		
	}
	public void editar() {
		
	}
	public void deletar() {
		
	}
}
