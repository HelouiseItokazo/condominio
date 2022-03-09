package br.com.fiap.loja.situacao;

import br.com.fiap.loja.Pedido;

public class Entregue extends Situacao {

	@Override
	public void abrirChamado(Pedido pedido) {
		System.out.println("Chamado aberto para departamento POS VENDA");
	}

}
