package com.dio;

import lombok.Data;

@Data
public abstract class Conta implements IConta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected Banco banco;
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;


	public Conta(Cliente cliente, Banco banco) {
		agencia = AGENCIA_PADRAO;
		numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.banco = banco;
	}
	
	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public void imprimirExtrato() {
		System.out.println(String.format("Titular: %s", cliente.getNome()));
		System.out.println(String.format("Agencia: %d", agencia));
		System.out.println(String.format("Numero: %d", numero));
		System.out.println(String.format("Saldo: %.2f", saldo));
	}
}
