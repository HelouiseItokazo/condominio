package br.com.fiap.progamer.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.progamer.dao.SetupDao;
import br.com.fiap.progamer.model.Setup;
import br.com.fiap.progamer.service.UploadService;

@Named
@RequestScoped
public class SetupBean {

	private Setup setup = new Setup();
	
	@Inject
	private SetupDao dao;
	
	private UploadedFile image;

	public String save() {
		System.out.println(setup);
		
		String path = UploadService.write(image, "setups");
		setup.setImagePath(path);
		
		dao.create(setup);
		
		showMessage("Setup cadastrado com sucesso");
		
		return "setups?faces-redirect=true";
	}
	
	public List<Setup> list() {
		return dao.listAll();
	}
	
	public String remove(Setup setup) {
		dao.delete(setup);
		showMessage("Setup apagado com sucesso");
		return "setups?faces-redirect=true";
	}
	
	public void edit() {
		dao.update(setup);
		showMessage("Setup atualizado com sucesso");
	}

	private void showMessage(String msg) {
		FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getFlash()
			.setKeepMessages(true);
		
		FacesMessage facesMessage = new FacesMessage(msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}
	
}
