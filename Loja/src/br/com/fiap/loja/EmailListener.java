package br.com.fiap.loja;

public class EmailListener implements SituacaoListener {

	@Override
	public void update(Pedido pedido) {
		System.out.println("Enviar email para o pedido " + pedido.getValor());		
	}

}
