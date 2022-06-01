package br.com.fiap.condominio.bean;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.condominio.dao.VisitanteDao;
import br.com.fiap.condominio.model.Visitante;
import br.com.fiap.condominio.service.UploadService;

@Named
@RequestScoped
public class VisitanteBean {

	private Visitante visitante = new Visitante();
	private UploadedFile image;

	@Inject
	private VisitanteDao dao;

	public String save() {
		System.out.println(visitante);
		visitante.setDataCadastro(LocalDate.now());
		String path = UploadService.write(image, "visitantes");
		visitante.setImagePath(path);
		dao.create(visitante);

		FacesMessage facesMessage = new FacesMessage("Visitante cadastrado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		return "visitantes";
	}

	public List<Visitante> list() {
		return dao.listAll();
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public VisitanteDao getDao() {
		return dao;
	}

	public void setDao(VisitanteDao dao) {
		this.dao = dao;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}
	
}
