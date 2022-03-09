package br.com.fiap.loja.teste;

import br.com.fiap.loja.Pedido;
import br.com.fiap.loja.SituacaoListener;

public class LogListener implements SituacaoListener {

	@Override
	public void update(Pedido pedido) {
		System.err.println("LOG: mudou a situacao " + pedido.getValor());

	}

}
