package controller;

import java.util.Scanner;
import java.util.ArrayList;

import frames.*;

/**
 * 
 * Classe principal do programa de bicicletas compartilhadas
 * 
 * @author iagom, marcusmartinsxx
 * @version 4.00
 * @since Release 3 da aplicacao
 *
 */
public class Main {
	
	public static Scanner ler = new Scanner(System.in);

	/**
	 * 
	 * Metodo principal do programa
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		/**
		 * Variaveis necessarias para o funcionamento do teste
		 */
		int ID, indexLog = -1, opcaonum, cout = 0;
		int posUsuario = -1,posPitStop = -1, i;
		char opcao1, opcao2, opcao3;
		boolean existe;
		String tempEmail, emailLog, busca; 
		String tempSenha, senhaLog;
		/** 
		 * Declaracao de objetos vetorizados
		 */
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<PitStop> pitstops = new ArrayList<>();
		Aluguel aluguel = new Aluguel(0, 0, null, null);
		Endereco taguatinga = new Endereco(1547896571, "DF", "Taguatinga", "QNG 12", null, 24);
		Endereco ceilandia = new Endereco(1874135465, "DF", "Ceilandia", "QNM 45", null, 17);
		Endereco luziania = new Endereco(1124653214, "GO", "Luziania", "Rua do comercio 15", null, 14);
		Usuario usuario1 = new Usuario("171717", "iago@gmail.com", "arroz1A", "Iago de Sousa Campelo Matos", "12345674899", "6188798845", "8526314", 12121212, "DF", "Taguatinga", "QNG 22", null, 34);
		Usuario usuario2 = new Usuario("151515", "marcus@gmail.com", "feijao1A", "Marcus Vinicius Paiva Martins", "45456879221", "6187963121", "57898451", 13131313, "DF", "Taguatinga", "QNF 12", null, 24);
		Usuario usuario3 = new Usuario("111111", "millena@hotmail.com", "salada1A", "Millena de Abreu Queiroz", "78965832515", "6287456512", "8946124", 19191919, "GO", "Luziania", "Rua do comercio 24", null, 12);
		PitStop pitstop1 = new PitStop(taguatinga, 20, 10, 1547896571, "DF", "Taguatinga", "QNG 12", null, 24);
		PitStop pitstop2 = new PitStop(ceilandia, 25, 3, 1874135465, "DF", "Ceilandia", "QNM 45", null, 17);
		PitStop pitstop3 = new PitStop(luziania, 17, 17, 1124653214, "GO", "Luziania", "Rua do comercio 15", null, 14);
		/** 
		 * Menu principal
		 */
		do {
			int n = usuarios.size();//Define o tamanho da quantidade atual de usuários
			opcao1 = menu();
			switch(opcao1) {
				case '1': // Opcao Usuario
					opcao2 = menuUsuario();
					for(i = 0; i < usuarios.size(); i++) {
						System.out.println(usuarios.get(i).getCEP() + usuarios.get(i).getNome());
					}
	                    switch(opcao2) {
	                        case '1': // Login de Usuario
	                        	indexLog = -1;
	                        	System.out.print("Digite seu e-mail:");
	                        	ler.nextLine();
	                        	tempEmail = ler.nextLine();
	                        	System.out.print("Digite sua senha:");
	                        	tempSenha = ler.nextLine();
	                            for (i=0; i<n; i++) {
	                              Usuario usuario = usuarios.get(i);
	                              if(usuario.getEmail().equals(tempEmail) && usuario.getSenha().equals(tempSenha)) {
	                            	  emailLog = tempEmail;
	                            	  senhaLog = tempSenha;
	                            	  indexLog = i;
	                            	  System.out.println("Logado com sucesso!");
	                            	  break;
	                              }
	                            }
	                            if(indexLog == -1)
	                            	System.out.println("Nao foi possivel realizar o login, verifique seu e-mail e senha.");
	                        	break;
	                        case '2': // Cadastro de Usuario
	                        	Usuario usuario = new Usuario(null, null, null, null, null, null, null, 0, null, null, null, null, 0);
	                        	usuario.cadastraUsuario(null);
	                        	usuarios.add(usuario);
	                        	System.out.print("Seu usuario eh: ");
	                        	usuario.setId(usuario.toString());
	                        	System.out.println(usuario.getId());
	                            break;
	                        case '3':
	                        	if(indexLog == -1) {
	                        		System.out.println("Faça o Login primeiro.");
	                        	}else {
	                        		opcao3 = menuEditaUsuario();
	                        		switch(opcao3) {
	                        		case '1':
	                        			usuarios.get(indexLog).editaUsuario();
	                        			break;
	                        		case '2':
	                        			usuarios.get(indexLog).editaPessoa();
	                        			break;
	                        		default:
	                        			break;
	                        		}
	                        	}
	                            break;
	                        case '4': // Deleta Usuario
	                        	if(indexLog == -1) {
	                        		System.out.println("Faça o Login primeiro.");
	                        	}else{
	                        		indexLog = -1;
	                        		usuarios.remove(indexLog);
	                        		System.out.println("Usuario deletado com sucesso");
	                        			break;
	                        		}
	                        	}
	                        	break;
				case '2': // Opcao PitStops
					opcao2 = menuPitStop();//1Cadastrar 2Deletar 3Visualizar 4Buscar 5Cadastra Bici 6Retirar Bici
					switch (opcao2) {
						case '1':
							PitStop pitstop = new PitStop(null, 0, 0, 0, null, null, null, null, 0);
							pitstop.cadastraPitStop();
                        	pitstops.add(pitstop);
							break;
						case '2':
							System.out.println("Os pitstops cadastrados sao:\n");
							if(pitstops.size() != 0) {
								for(i = 0; i < pitstops.size(); i++) {
									System.out.print(i+1 + "- ");
									System.out.println(pitstops.get(i).getCidade() + "-" + pitstops.get(i).getEstado()
													 + " " + pitstops.get(i).getNumero());
								}
								System.out.println("Digite o numero do pitstop que deseja excluir");
								ler.nextLine();
								opcaonum = ler.nextInt();
								for(i = 0; i < pitstops.size(); i++) {
									if(i+1 == opcaonum){
										pitstops.remove(i);
										System.out.println("PitStop removido com sucesso.");
										break;
									}
								}
								System.out.println("Exclusao nao foi realizada.");
							}else
								System.out.println("Nao existe nenhum PitStop cadastrado.");
							break;
						case '3':
							for(i = 0; i < pitstops.size(); i++) {
								System.out.print(i+1 + "- ");
								System.out.println(pitstops.get(i).getCidade() + "-" + pitstops.get(i).getEstado()
												 + " " + pitstops.get(i).getLogradouro()+" "+ pitstops.get(i).getNumero() + 
												 "\nNum. Bicicletas Atual: " + pitstops.get(i).getQtdAtualBicicletas() + 
												 "\nNum. Bicicletas Max: " + pitstops.get(i).getQtdMaxBicicletas());
							}
							break;
						case '4':
							existe = false;
							System.out.print("Digite o nome da Cidade que deseja buscar o PitStop:");
							ler.nextLine();
							busca = ler.nextLine();
							System.out.println("Resultados da busca: ");
							for(i = 0; i < pitstops.size(); i++) {
								if(pitstops.get(i).getCidade().contains(busca)){
									System.out.println(pitstops.get(i).getCidade() + "-" + pitstops.get(i).getEstado()
											 + " " + pitstops.get(i).getLogradouro()+" "+ pitstops.get(i).getNumero() + 
											 "\nNum. Bicicletas Atual: " + pitstops.get(i).getQtdAtualBicicletas() + 
											 "\nNum. Bicicletas Max: " + pitstops.get(i).getQtdMaxBicicletas() + "\n");
									existe = true;
								}
							}
							if(existe == false) {
								System.out.println("Nao foi possivel encontrar pitstops nesta cidade inserida, tente novamente.");
							}
							break;
						case '5':
							if(pitstops.size() != 0) {
								cout = 0;
								System.out.print("Digite o nome da Cidade em que o PitStop se localiza:");
								ler.nextLine();
								busca = ler.nextLine();
								System.out.println("Resultados da busca: ");
									for(i = 0; i < pitstops.size(); i++) {
										if(pitstops.get(i).getCidade().contains(busca)){
											System.out.print(i+1 + "- ");
											System.out.println(pitstops.get(i).getCidade() + "-" + pitstops.get(i).getEstado()
															 + " " + pitstops.get(i).getNumero());
											cout++;
										}
										
									}
									if(cout > 0) {
										System.out.print("Digite o numero do pitstop desejado:");
										opcaonum = ler.nextInt();
										for(i = 0; i < pitstops.size(); i++) {
											if(i+1 == opcaonum){
												pitstops.get(i).cadastraBicicleta();
												break;
											}
										}
									}else
										System.out.println("Nao foi encontrado nenhum pitstop.");
							}else
								System.out.println("Nao existe nenhum PitStop cadastrado.");
							break;
						case '6':
							if(pitstops.size() != 0) {
								cout = 0;
								System.out.print("Digite o nome da Cidade em que o PitStop se localiza:");
								ler.nextLine();
								busca = ler.nextLine();
								System.out.println("Resultados da busca: ");
									for(i = 0; i < pitstops.size(); i++) {
										if(pitstops.get(i).getCidade().contains(busca)){
											System.out.print(i+1 + "- ");
											System.out.println(pitstops.get(i).getCidade() + "-" + pitstops.get(i).getEstado()
															 + " " + pitstops.get(i).getNumero());
											cout++;
										}
										
									}
									if(cout > 0) {
										System.out.print("Digite o numero do pitstop desejado:");
										opcaonum = ler.nextInt();
										for(i = 0; i < pitstops.size(); i++) {
											if(i+1 == opcaonum){
												pitstops.get(i).retiraBicicleta();
												break;
											}
										}
									}else
										System.out.println("Nao foi encontrado nenhum pitstop.");
							}else
								System.out.println("Nao existe nenhum PitStop cadastrado.");
							break;
						default:
							break;
					}
					break;
				case '3': // Opcao Alugar
					opcao2 = menuAluguel();
					switch (opcao2) {
						case '1':
							aluguel.setHoraRetirada(null);
							System.out.println("Hora da retirada: " + aluguel.getHoraRetirada());
							break;
						case '2':
							aluguel.setHoraDevolucao(null);
							aluguel.devolver();
							//System.out.println("Hora da devolucao: " + aluguel.getHoraDevolucao());
							break;
						default:
							break;
					}
					
					break;
				case '4': // Opcao Encerrar
					System.out.println("Ate a proxima!");
					break;
				default:
					System.out.println("Opcao invalida! Tente novamente.");
					enter();
					break;
				}
		} while( opcao1 != '4' );
		
	}

	/**
	 * Metodo para print e retorno de opcao do menu principal
	 * @return opcao - Opcao escolhida pelo usuario
	 */
	public static char menu() {
		char opcao;
		System.out.println("----------Menu----------");
		System.out.println("1- Usuario\n2- PitStops\n3- Alugar\n4- Encerrar");
		opcao = ler.next().charAt(0);
		return opcao;
	}
	
	/**
	 * Metodo para fazer um "enter" na funcao
	 */
	public static void enter() {
		System.out.println("\nPressione Enter para continuar");
		ler.nextLine();
	}
	
	/**
	 * Metodo para print e retorno de opcao do menu de usuario
	 * @return opcao - Opcao escolhida pelo usuario
	 */
	public static char menuUsuario() {
		char opcao;
		System.out.println("------Menu-Usuario------");
		System.out.println("1- Login\n2- Cadastrar\n3- Editar\n4- Deletar");
		opcao = ler.next().charAt(0);
		return opcao;
	}
	
	/**
	 * Metodo para print e retorno de opcao do menu de editar usuario
	 * @return opcao - Opcao escolhida pelo usuario
	 */
	public static char menuEditaUsuario() {
		char opcao;
		System.out.println("---Menu-Edita-Usuario---");
		System.out.println("1- Informacoes de usuario\n2- Informacoes pessoais");
		opcao = ler.next().charAt(0);
		return opcao;
	}
	
	/**
	 * Metodo para print e retorno de opcao do menu de pitstop
	 * @return opcao - Opcao escolhida pelo usuario
	 */
	public static char menuPitStop() {
		char opcao;
		System.out.println("------Menu-PitStop------");
		System.out.println("1- Cadastrar \n2- Deletar\n3- Visualizar\n4- Buscar\n5- Cadastra Bicicleta\n6- Retirar Bicicleta");
		opcao = ler.next().charAt(0);
		return opcao;
	}
	
	/**
	 * Metodo para print e retorno de opcao do menu de aluguel
	 * @return opcao - Opcao escolhida pelo usuario
	 */
	public static char menuAluguel() {
		char opcao;
		System.out.println("------Menu-Aluguel------");
		System.out.println("1- Alugar \n2- Devolver");
		opcao = ler.next().charAt(0);
		return opcao;
	}
}
