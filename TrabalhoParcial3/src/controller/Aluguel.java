package controller;

import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * 
 * Classe de aluguel 
 * 
 * @author iagom, marcusmartinsxx
 * @version 4.00
 * @since Release 3 da aplicacao
 *
 */

public class Aluguel {
	// Atributos
	private float valorHora;
	private int qtdDisponivelBicicletas;
	private String horaRetirada; 
	private String horaDevolucao;
	
	/**
	 * Metodo Construtor de Aluguel
	 * 
	 * @param valorHora - valor da hora do aluguel
	 * @param qtdDisponivelBicicletas - quantidade disponivel de bicicletas para aluguel
	 * @param horaRetirada - o horario que o usuario realiza o a retirada da bici
	 * @param horaDevolucao - o horario que o usuario realiza o retorno da bici
	 */
	public Aluguel(float valorHora, int qtdDisponivelBicicletas, String horaRetirada, String horaDevolucao) {
		this.valorHora = valorHora;
		this.qtdDisponivelBicicletas = qtdDisponivelBicicletas;
		this.horaRetirada = horaRetirada;
		this.horaDevolucao = horaDevolucao;
	}
	// Getters e Setters
	public float getValorHora() {
		return valorHora;
	}
	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}
	public int getQtdDisponivelBicicletas() {
		return qtdDisponivelBicicletas;
	}
	public void setQtdDisponivelBicicletas(int qtdDisponivelBicicletas) {
		this.qtdDisponivelBicicletas = qtdDisponivelBicicletas;
	}
	public String getHoraRetirada() {
		return horaRetirada;
	}
	public void setHoraRetirada(String horaRetirada) {
		this.horaRetirada = horaRetirada;
	}
	public String getHoraDevolucao() {
		return horaDevolucao;
	}
	public void setHoraDevolucao(String horaDevolucao) {
		this.horaDevolucao = horaDevolucao;
	}
	// Metodos
	/**
	 * Metodo que faz o registro do aluguel da bicicleta
	 */
	public void alugar() {
		this.horaRetirada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Data da devolucao: " + this.horaDevolucao);
	}
	/**
	 * Metodo que faz o registro da devolucao da bicicleta
	 */
	public void devolver() {
		this.horaDevolucao = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Data da devolucao: " + this.horaDevolucao);
	}
	/**
	 * Metodo que verifica se existe alguma bicicleta disponivel
	 * para aluguel
	 * @return true - se existe
	 * @return false - se nao existe
	 */
	public boolean verifDisponibilidade() {
		if(this.getQtdDisponivelBicicletas() != 0) {
			return true;
		}else
			return false;
	}
}