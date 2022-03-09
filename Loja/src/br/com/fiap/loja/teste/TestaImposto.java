package br.com.fiap.loja.teste;

import java.math.BigDecimal;

import br.com.fiap.loja.Pedido;
import br.com.fiap.loja.imposto.CalculadoraDeImposto;
import br.com.fiap.loja.imposto.Icms;
import br.com.fiap.loja.imposto.Iss;

public class TestaImposto {
	
	public static void main(String[] args) {
		
		Pedido pedido = new Pedido(new BigDecimal(100), 1);
		CalculadoraDeImposto calculadoraDeImposto = new CalculadoraDeImposto();
		
		calculadoraDeImposto.setImposto(new Icms(new Iss(null)));
		BigDecimal imposto = calculadoraDeImposto.calcular(pedido);
		System.out.println(imposto);
		
	}

}
