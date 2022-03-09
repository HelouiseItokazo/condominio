package br.com.fiap.loja.teste;

import java.math.BigDecimal;

import br.com.fiap.loja.EmailListener;
import br.com.fiap.loja.Pedido;
import br.com.fiap.loja.PedidoProxy;

public class TestaProxy {
	
	public static void main(String[] args) {
		Pedido pedido = new PedidoProxy( new Pedido(new BigDecimal(100), 1) );
		pedido.getManager().subscribe(new EmailListener());
		pedido.getManager().subscribe(new LogListener());
	
		System.out.println(pedido.getValor());
		
		pedido.pagar();
		
		
	}

}
