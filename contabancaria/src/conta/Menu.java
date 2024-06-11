package conta;

import java.util.*;
import conta.util.Cores;
public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		int opcao;
		while (true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     "+Cores.TEXT_RESET);
			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("Banco doe Brazil com Z -- Seu futuro começa aqui! ;)");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Criar conta \n\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+"LIstar todas as contas \n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Buscar conta por Numero\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar Dados da conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar conta\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depositar\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Transferir valores entre contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"Opção invalida");
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Édipo Reis Torres ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("github.com/EdiporTorres");
		System.out.println("*********************************************************");
	}
}