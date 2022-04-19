package br.com.fiap.progamer.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.progamer.dao.SetupDao;
import br.com.fiap.progamer.model.Setup;

@Named
@RequestScoped
public class SetupBean {
	
	private Setup setup = new Setup();
	
	@Inject
	private SetupDao dao;

	public String save() {
		System.out.println(setup);
		dao.create(setup);
		
		FacesMessage facesMessage = new FacesMessage("Setup cadastrado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		
		return "setups";
	}
	
	public List<Setup> list() {
		return dao.listAll();
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	
}
