package br.com.fiap.condominio.validator;

import java.time.LocalDate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dataNascimentoValidator")
public class DataNascimentoValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String stringDate = value.toString();
		LocalDate inputDate = LocalDate.parse(stringDate);

		if (inputDate.isAfter(LocalDate.now())) {
			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na validação de data",
					"A data deve ser inferior a data atual.");
			throw new ValidatorException(fmsg);
		}
	}
}