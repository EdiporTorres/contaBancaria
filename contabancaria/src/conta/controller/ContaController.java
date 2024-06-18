package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();{
		
	}
	int numero = 0;
	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrar(Conta conta) {
		// TODO Auto-generated method stub
		listaContas.add(conta);
		System.out.println("\nA Conta numero: "+ conta.getNumero()+ "Foi criado com sucesso!!");
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		var buscaConta = buscarNaColletion(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\n A Conta numero: " + conta.getNumero() + "Foi atualizada com sucesso!");
		}else
			System.out.println("\nA conta numero: "+ conta.getNumero()+ "Não foi encontrada");
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		var conta = buscarNaColletion(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta)== true)
				System.out.println("\nA conta numero: "+ numero+ "foi deletada com sucesso!");
			} else
				System.out.println("\nA conta numero: "+ numero + "Não foi encontrada!");
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		var conta = buscarNaColletion(numero);
		if (conta != null) {
		if (conta.sacar(valor)==true)
			System.out.println("\n O Saque da Conta numer: "+numero+"foi efetuado com sucesso!");
		}else
			System.out.println("\nA Conta numero: "+ numero+ "Não foi encontrada!");
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		var conta = buscarNaColletion(numero);
		
		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\nO Deposito na conta numero: "+ numero + "Foi efetuado com sucesso!");
		}else
			System.out.println("\nA Conta numero: "+numero+ " não foi encontrada");
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		var contaOrigem = buscarNaColletion(numeroOrigem);
		var contaDestino = buscarNaColletion(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor)== true) {
				contaDestino.depositar(valor);
				System.out.println("\nA Transferencia foi efetuada com sucesso!");
			}
		}else 
			System.out.println("\nA conta de Origem e/ou Destino não foram encontrada!");
	}
	
	public int gerarNumero(){
		return ++numero;
	}
	public Conta buscarNaColletion(int numero) {
		for (var conta: listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
