package controller;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * Classe de bicicleta 
 * 
 * @author iagom, marcusmartinsxx
 * @version 4.00
 * @since Release 3 da aplicacao
 *
 */

public class Bicicleta {
	// Atributos
	private long id;
	private String marca;
	private boolean status;
	private int totalBicicletas =  50; // valor temporario da quantidade de bicicletas
	Scanner ler = new Scanner(System.in);
	Random gerador = new Random();
	/**
	 * Metodo Construtor de Bicicleta
	 * @param id - o id da bicicleta
	 * @param marca - a marca da bicicleta
	 * @param status - indica se a bicicleta esta sendo usada ou nao
	 */
	public Bicicleta(int id, String marca, boolean status) {
		super();
		this.id = id;
		this.marca = marca;
		this.status = status;
	}
	// Getters e Setters
	public long getID() {
		return id;
	}

	public void setID(long i) {
		this.id = i;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// Metodos
	/**
	 * Cadastra uma bicicleta nova no sistema
	 * @param bicicleta - a bicicleta que sera cadastrada
	 */
	public void cadastrar(Bicicleta bicicleta[]) {
		int i;
		
		// Setando id primário randomicamente 
		long tmpID;
		boolean existe;
		
		do {
			existe = false;
			tmpID = gerador.nextLong();
			for(i = 0; i < totalBicicletas; i++) {
				if ( tmpID == bicicleta[i].id )
				{
					existe = true;
					break;
				}
			}			
		}while(existe || tmpID == 0);
		
		// Definindo marca da bicicleta
		String tmpString;
		System.out.println("	Qual a marca da bicicleta a ser cadastrada? ");
		tmpString = ler.nextLine();
		tmpString = tmpString.toUpperCase();
		
		// Os atributos cadastrados retornados para o objeto
		this.id = tmpID;
		this.marca = tmpString;
		this.status = true;
	}
	/**
	 * Metodo que deleta uma bicicleta do sistema
	 * @param bicicleta - a bicicleta que sera deletada
	 */
	public void deletar(Bicicleta bicicleta[]) {
		int i;
		long tmpID;
		
		System.out.println("	Qual o ID da bicicleta a ser deletada? ");
		tmpID = ler.nextLong();
		
		for(i = 0; i < totalBicicletas; i++) {
			if ( tmpID == bicicleta[i].id )
			{
				bicicleta[i].setID(0);
				bicicleta[i].setMarca(null);
				bicicleta[i].setStatus(false);
			}
			else
			{
				if ( i == totalBicicletas - 1 )
				{
					System.out.println("	ERRO! A bicicleta nao foi encontrada");
				}
			}
		}
	}
	/**
	 * Metodo que faz a busca de uma bicicleta pelo ID
	 * @param bicicleta - a bicicleta que sera buscada
	 */
	public void buscar(Bicicleta bicicleta[]) {
		int i;
		long tmpID;
		
		System.out.println("	Qual o ID da bicicleta a ser deletada? ");
		tmpID = ler.nextLong();
		
		for(i = 0; i < totalBicicletas; i++) {
			if ( tmpID == bicicleta[i].id )
			{
				System.out.printf("	A marca da bicicleta eh: ", bicicleta[i].getMarca(), '\n');
				System.out.print("	O status da bicicleta eh: ");
					if( bicicleta[i].getStatus() ) {
						System.out.println("DISPONIVEL");
					}
					else
					{
						System.out.println("INDISPONIVEL");
					}
			}
			else
			{
				if ( i == totalBicicletas - 1 )
				{
					System.out.println("	ERRO! A bicicleta nao foi encontrada");
				}
			}
		}
	}
}
