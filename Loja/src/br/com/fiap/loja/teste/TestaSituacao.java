package br.com.fiap.loja.teste;

import java.math.BigDecimal;

import br.com.fiap.loja.EmailListener;
import br.com.fiap.loja.Pedido;

public class TestaSituacao {
	
	public static void main(String[] args) {
		
		Pedido pedido = new Pedido(new BigDecimal(100), 1);
		pedido.getManager().subscribe(new EmailListener());
		pedido.getManager().subscribe(new LogListener());

		pedido.abrirChamado();
		
		pedido.pagar();
		pedido.entregar();
		pedido.abrirChamado();
		
		//pedido.cancelar();

		
	}

}
