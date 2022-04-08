package controller;

/**
 * 
 * Classe de endereco 
 * 
 * @author iagom, marcusmartinsxx
 * @version 4.00
 * @since Release 3 da aplicacao
 *
 */

public class Endereco{
	// Atributos
	protected long cep;
	protected String estado;
	protected String cidade;
	protected String logradouro;
	protected String complemento;
	protected int numero;
	/** 
	 * Metodo Construtor de Endereco
	 * 
	 * @param cep - o cep pertencente ao endereco
	 * @param estado - o estado pertencente ao endereco
	 * @param cidade - a cidade pertencente ao endereco
	 * @param logradouro - a rua pertencente ao endereco
	 * @param complemento - o complemento do endereco, se existir
	 * @param numero - o numero pertecente ao endereco
	 */
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
}
