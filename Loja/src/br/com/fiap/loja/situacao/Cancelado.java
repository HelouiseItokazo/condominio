package br.com.fiap.loja.situacao;

import br.com.fiap.loja.Pedido;

public class Cancelado extends Situacao {

	@Override
	public void abrirChamado(Pedido pedido) {
		System.out.println("Chamado aberto para departamento COMERCIAL");
	}

	@Override
	public void reabrir(Pedido pedido) {
		pedido.setSituacao(new Aberto());
	}
	
	

}
