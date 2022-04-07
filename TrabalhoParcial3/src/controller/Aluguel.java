package controller;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Aluguel {
	// Atributos
	private float valorHora;
	private int qtdDisponivelBicicletas;
	private String horaRetirada; 
	private String horaDevolucao;
	
	// Metodo Construtor de Aluguel
	public Aluguel(float d, int qtdDisponivelBicicletas, String horaRetirada, String horaDevolucao) {
		this.valorHora = d;
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
	public void alugar() {
		this.horaRetirada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Data da devolucao: " + this.horaDevolucao);
	}
	public void devolver() {
		this.horaDevolucao = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Data da devolucao: " + this.horaDevolucao);
	}
	public boolean verifDisponibilidade() {
		if(this.getQtdDisponivelBicicletas() != 0) {
			return true;
		}else
			return false;
	}
}