package br.com.fiap.loja.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.fiap.loja.Pedido;
import br.com.fiap.loja.desconto.CalculadoraDeDesconto;

class DescontoTest {

	@Test
	void deveRetornarUmDescontoParaPedidosCaros() {
		Pedido pedido = new Pedido(new BigDecimal(600), 20);
		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		BigDecimal desconto = calculadoraDeDesconto.calcular(pedido);
		
		assertEquals(new BigDecimal("60.00"), desconto.setScale(2, RoundingMode.DOWN));
	}
	
	@Test
	void deveRetornarUmDescontoParaPedidosGrandes() {
		Pedido pedido = new Pedido(new BigDecimal(100), 20);
		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		BigDecimal desconto = calculadoraDeDesconto.calcular(pedido);
		
		assertEquals(new BigDecimal("5.00"), desconto.setScale(2, RoundingMode.DOWN));
	}
	
	@Test
	void deveRetornarZeroSeNaoAplicarOsOutrosDescontos() {
		Pedido pedido = new Pedido(new BigDecimal(100), 1);
		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		BigDecimal desconto = calculadoraDeDesconto.calcular(pedido);
		
		assertEquals(BigDecimal.ZERO, desconto);
	}

}
