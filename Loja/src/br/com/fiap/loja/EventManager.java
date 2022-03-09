package br.com.fiap.loja;

import java.util.ArrayList;
import java.util.List;

public class EventManager { 
	
	private List<SituacaoListener> listeners = new ArrayList<SituacaoListener>();
	
	public void subscribe(SituacaoListener listener) {
		listeners.add(listener);
	}
	
	public void unsubscribe(SituacaoListener listener) {
		listeners.remove(listener);
	}
	
	public void notifyListeners(Pedido pedido) {
		listeners.forEach(listener -> listener.update(pedido));
	}
	
}
