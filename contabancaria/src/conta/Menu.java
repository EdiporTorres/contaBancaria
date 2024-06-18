package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ContaController conta = new ContaController();
		int opcao, numero, agencia, tipo, aniversario, NumeroDestino;
		;
		String titular;
		float saldo, limite, valor;

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
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\n Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("Banco doe Brazil com Z -- Seu futuro começa aqui! ;)");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "\n Criar Conta");

				System.out.println("Digite o Numero da agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);
				System.out.println("Digite o Saldo da Conta R$: ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite do Crédito R$: ");
					limite = leia.nextFloat();
					conta.cadastrar(new ContaCorrente(conta.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o Aniversario da conta: ");
					aniversario = leia.nextInt();
					conta.cadastrar(new ContaPoupanca(conta.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "\n Listar todas as Contas");
				conta.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "\n Buscar Conta por número");
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();

				conta.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "\n Atualizar dados da Conta");

				System.out.println("Digite o numero da COnta: ");
				numero = leia.nextInt();

				var buscaConta = conta.buscarNaColletion(numero);

				if (buscaConta != null) {
					tipo = buscaConta.getTipo();

					System.out.println("Digite o numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("DIgite o nome do Titular ");
					leia.skip("\\R?");
					titular = leia.nextLine();

					System.out.println("Digite o Saldo da conta: ");
					saldo = leia.nextFloat();
					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite do Crédito R$: ");
						limite = leia.nextFloat();
						conta.atualizar(new ContaCorrente(conta.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o Aniversario da conta: ");
						aniversario = leia.nextInt();
						conta.atualizar(
								new ContaPoupanca(conta.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta invalido!");
					}
					}
					}else {
						System.out.println("Conta não  foi encontrada!");
					keyPress();
					break;
				}
			case 5:
				System.out.println(Cores.TEXT_WHITE + "\n Apagar Conta");
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();
				conta.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "\n Sacar");
				
				System.out.println("Digite o Numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do Saque R$: ");
					valor = leia.nextFloat();
				}while(valor <=0);
				conta.sacar(numero,valor);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "\n Depositar");
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do deposito R$: ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				conta.depositar(numero,valor);
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "\n Transferir");
				System.out.println("Digite o Numero da conta de Origem: ");
				numero =leia.nextInt();
				System.out.println("Digite o numero da Conta Destino: ");
				NumeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o valor da transferencia R$: ");
					valor = leia.nextFloat();
				}while (valor <=0);
				
				conta.transferir(numero,NumeroDestino,valor);
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_WHITE + "\nOpção Inválida" + Cores.TEXT_RESET);

				keyPress();
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

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\n Pressione Enter para Continuar..");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla  diferente de enter!");
		}
	}
}
