import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		// Variaveis de teste
		int ID, indexLog = -1;
		int posUsuario = -1, i;
		char opcao1, opcao2, opcao3;
		boolean existe;
		String tempEmail, emailLog; 
		String tempSenha, senhaLog;
		// Declaracao de objetos vetorizados
		ArrayList<Bicicleta> bicicletas = new ArrayList<>();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<PitStop> pitstops = new ArrayList<>();
		ArrayList<Aluguel> aluguels = new ArrayList<>();
		
		
		// Menus
		do {
			int n = usuarios.size();
			opcao1 = menu();
			switch(opcao1) {
				case '1': // Opcao Usuario
					opcao2 = menuUsuario();
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
	                              }
	                            }
	                            if(indexLog == -1)
	                            	System.out.println("Nao foi possivel realizar o login, verifique seu e-mail e senha.");
	                        	break;
	                        case '2': // Cadastro de Usuario
	                        	Usuario usuario = new Usuario(null, null, null, null, null, null, null);
	                        	usuario.cadastraUsuario(null);
	                        	usuarios.add(usuario);
	                        	System.out.print("Seu usuario eh: ");
	                        	posUsuario++;
	                        	usuario.setId(usuarios.get(posUsuario).toString());
	                        	System.out.println(usuarios.get(posUsuario).getId());
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
							
							break;
						case '2':
							
							break;
						case '3':
							
							break;
						case '4':
							
							break;
						case '5':
							
							break;
						case '6':
							
							break;
						default:
							break;
					}
					break;
				case '3': // Opcao Alugar
					opcao2 = menuAluguel();
					switch (opcao2) {
						case '1':
							
							break;
						case '2':
							
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
