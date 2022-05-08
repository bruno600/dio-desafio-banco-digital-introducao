package com.dio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Banco {
	
	private String nome;
	private List<Conta> contas;
	
	public Banco(String nome) {
		contas = new ArrayList<>();
		this.nome = nome;
	}
	
	public List<Conta> getContas() {
		return Collections.unmodifiableList(contas);
	}

	public void criarConta(ContaTipo tipo, Cliente cliente) {
		if (tipo.equals(ContaTipo.CORRENTE)) {
			contas.add(new ContaCorrente(cliente, this));
			return;
		}
		if (tipo.equals(ContaTipo.POUPANCA)) {
			contas.add(new ContaPoupanca(cliente, this));
			return;
		}
		System.out.println("Valor do Tipo da conta informado esta incorreto!");
	}
	
	public List<Conta> getClienteContas(Cliente cliente) {
		return contas.stream()
			.map(c -> c.getCliente().equals(cliente) ? c : null).collect(Collectors.toList());
	}
}
