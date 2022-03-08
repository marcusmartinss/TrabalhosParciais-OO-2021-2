import java.util.Scanner;

public class Main {
	public static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		char opcao;
		do {
			opcao = menu();
			switch(opcao) {
				case '1':
					break;
				case '2':
					break;
				case '3':
					break;
				case '4':
					
					break;
				default:
					System.out.println("Opcao invalida! Tente novamente.");
					enter();
					break;
			}
		} while( opcao != '4' );
		
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
		System.out.println("1- Cadastrar\n2- Editar\n3- Alugar\n4- Encerrar");
		opcao = ler.next().charAt(0);
		return opcao;
	}
}
