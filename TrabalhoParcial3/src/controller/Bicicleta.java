package controller;

import java.util.Random;
import java.util.Scanner;

public class Bicicleta {
	// Atributos
	private long id;
	private String marca;
	private boolean status;
	
	private int totalBicicletas =  50; // valor temporario da quantidade de bicicletas
	Scanner ler = new Scanner(System.in);
	Random gerador = new Random();
	// Metodo Construtor de Bicicleta
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
	public void cadastrar(Bicicleta bicicleta[]) {
		int i;
		
		// Setando id prim�rio randomicamente 
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
