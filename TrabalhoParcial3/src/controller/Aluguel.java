package controller;

import java.util.Date;
import java.util.Calendar;


public class Aluguel {
	// Atributos
	private float valorHora;
	private int qtdDisponivelBicicletas;
	private Date horaRetirada;
	private Date horaDevolucao;
	Calendar c = Calendar.getInstance();
	// Metodo Construtor de Aluguel
	public Aluguel(float d, int qtdDisponivelBicicletas, Date horaRetirada, Date horaDevolucao) {
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
	public Date getHoraRetirada() {
		return horaRetirada;
	}
	public void setHoraRetirada(Date horaRetirada) {
		this.horaRetirada = c.getTime();
	}
	public Date getHoraDevolucao() {
		return horaDevolucao;
	}
	public void setHoraDevolucao(Date horaDevolucao) {
		this.horaDevolucao = c.getTime();
	}
	// Metodos
	public void alugar() {
		setHoraRetirada(horaRetirada);
	}
	public void devolver() {
		setHoraDevolucao(horaDevolucao);
	}
	public boolean verifDisponibilidade() {
		if(getQtdDisponivelBicicletas() != 0) {
			return true;
		}else
			return false;
	}
}