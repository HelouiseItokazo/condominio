package br.com.fiap.loja.situacao;

import br.com.fiap.loja.Pedido;

public class Pago extends Situacao {

	@Override
	public void abrirChamado(Pedido pedido) {
		System.out.println("Chamado aberto para departamento LOGISTICA");
	}

	@Override
	public void entregar(Pedido pedido) {
		pedido.setSituacao(new Entregue());
	}
	
	

}
