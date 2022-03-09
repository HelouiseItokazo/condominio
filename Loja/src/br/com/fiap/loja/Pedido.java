package br.com.fiap.loja;

import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Aberto;
import br.com.fiap.loja.situacao.Situacao;

public class Pedido {

	private BigDecimal valor;
	private int totalDeItens;
	private Situacao situacao = new Aberto();
	private EventManager manager = new EventManager();
	
	public Pedido(BigDecimal valor, int totalDeItens) {
		super();
		this.valor = valor;
		this.totalDeItens = totalDeItens;
		PedidoFacade.criarPedido();
	}
	
	public Pedido(BigDecimal valor) {
		PedidoFacade.criarPedido();
	}
	
	public void abrirChamado() {
		situacao.abrirChamado(this);
	}

	public void pagar() {
		situacao.pagar(this);
	}

	public void entregar() {
		situacao.entregar(this);
	}

	public void cancelar() {
		situacao.cancelar(this);
	}

	public void reabrir() {
		situacao.reabrir(this);
	}

	public BigDecimal getValor() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return valor;
	}
	
	public int getTotalDeItens() {
		return totalDeItens;
	}

	public void setSituacao(Situacao situacao) {
		getManager().notifyListeners(this);
		this.situacao = situacao;
	}

	public EventManager getManager() {
		return manager;
	}
	
	
}
