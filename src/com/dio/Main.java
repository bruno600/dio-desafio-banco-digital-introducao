package com.dio;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco("Santander");
		Cliente bruno = new Cliente();
		bruno.setNome("Bruno");
		
		banco.criarConta(ContaTipo.CORRENTE, bruno);
		banco.criarConta(ContaTipo.POUPANCA, bruno);
		
		List<Conta> brunoContas = banco.getClienteContas(bruno);
		
		Conta cc = brunoContas.get(0);
		Conta cp = brunoContas.get(1);
		
		
		cc.depositar(100);
		cc.transferir(60, cp);
		
		cc.imprimirExtrato();
		cp.imprimirExtrato();
	}

}
