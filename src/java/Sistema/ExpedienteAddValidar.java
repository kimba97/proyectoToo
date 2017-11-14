
package Sistema;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class ExpedienteAddValidar implements Validator {
    @Override
    public boolean supports(Class<?> type) 
    {
       return Expediente.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Expediente expediente = (Expediente)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codExpe", 
        "required.codExpe","El campo Codigo Expediente es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "profesion", 
        "required.profesion","El campo Profesion u Oficio es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "estadoCivil", 
        "required.estadoCivil","El campo Estado Civil es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomMadre", 
        "required.nomMadre","El campo Nombre de la Madre es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomPadre", 
        "required.nomPadre","El campo Nombre del Padre es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomConyuge", 
        "required.nomConyuge","El campo Nombre del Conyuge es obligatorio");
        
    }
}
