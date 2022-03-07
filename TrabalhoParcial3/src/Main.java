import java.util.Scanner;

public class Main {
	public static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		
		System.out.println("Bem vindo ao aluguel de bicicletas!");
		System.out.println("\n---------------------------------------\n");
		System.out.println("Aqui sera possivel alugar bicicletas, contratar planos e muito mais" + 
							", tudo diretamente do seu dispositivo!");
		System.out.println("Pressione Enter para continuar");
		ler.nextLine();
		
		do{
			n = menu();
			switch(n) {
			case '1':
				System.out.println("1");
				break;
			case '2':
				System.out.println("2");
				break;
			case '3':
				System.out.println("3");
				break;
			case '4':
				System.out.println("4");
				break;
			case '5':
				System.out.println("Ate a proxima!");
				break;
			default:
				System.out.println("Opcao invalida.");
			}
			
		}while(n != '5');
		
		}

	public static int menu() {
		char n;
		System.out.println("----------Menu----------");
		System.out.println("1- Usuario\n2- Planos\n3- PitStops\n4- Alugar\n5- Encerrar");
		n = ler.next().charAt(0);
		System.out.println(n);
		return n;
	}
}
