package br.com.fiap.progamer.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fiap.progamer.dao.SetupDao;
import br.com.fiap.progamer.model.Setup;

@Named
@RequestScoped
public class SetupBean {
	
	private Setup setup = new Setup();
	private List<Setup> list;
			
	public SetupBean(){
		this.list = list();
	}
	
	public void save() {
		System.out.println(setup);
		new SetupDao().create(setup);
	}
	
	public List<Setup> list() {
		SetupDao dao = new SetupDao();
		List<Setup> list = dao.listAll();
		return list;
	}
	
	

	public List<Setup> getList() {
		return list;
	}

	public void setList(List<Setup> list) {
		this.list = list;
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	
}
