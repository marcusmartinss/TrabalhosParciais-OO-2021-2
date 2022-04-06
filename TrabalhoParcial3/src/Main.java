import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		// Variaveis de teste
		int ID, indexLog = -1, opcaonum, cout = 0;
		int posUsuario = -1,posPitStop = -1, i;
		char opcao1, opcao2, opcao3;
		boolean existe;
		String tempEmail, emailLog, busca; 
		String tempSenha, senhaLog;
		// Declaracao de objetos vetorizados
		ArrayList<Bicicleta> bicicletas = new ArrayList<>();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<PitStop> pitstops = new ArrayList<>();
		Aluguel aluguel = new Aluguel(0, 0, null, null);
		
		
		// Menus
		do {
			int n = usuarios.size();
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
								System.out.println(i);
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
							System.out.println("Hora da devolucao: " + aluguel.getHoraDevolucao());
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

	public static char menu() {
		char opcao;
		System.out.println("----------Menu----------");
		System.out.println("1- Usuario\n2- PitStops\n3- Alugar\n4- Encerrar");
		opcao = ler.next().charAt(0);
		return opcao;
	}
	
	public static void enter() {
		System.out.println("\nPressione Enter para continuar");
		ler.nextLine();
	}
	
	public static char menuUsuario() {
		char opcao;
		System.out.println("------Menu-Usuario------");
		System.out.println("1- Login\n2- Cadastrar\n3- Editar\n4- Deletar");
		opcao = ler.next().charAt(0);
		return opcao;
	}
	
	public static char menuEditaUsuario() {
		char opcao;
		System.out.println("---Menu-Edita-Usuario---");
		System.out.println("1- Informacoes de usuario\n2- Informacoes pessoais");
		opcao = ler.next().charAt(0);
		return opcao;
	}
	
	public static char menuPitStop() {
		char opcao;
		System.out.println("------Menu-PitStop------");
		System.out.println("1- Cadastrar \n2- Deletar\n3- Visualizar\n4- Buscar\n5- Cadastra Bicicleta\n6- Retirar Bicicleta");
		opcao = ler.next().charAt(0);
		return opcao;
	}
	
	public static char menuAluguel() {
		char opcao;
		System.out.println("------Menu-Aluguel------");
		System.out.println("1- Alugar \n2- Devolver");
		opcao = ler.next().charAt(0);
		return opcao;
	}
}
