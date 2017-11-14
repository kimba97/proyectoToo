
package Sistema;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class PacienteAddValidar implements Validator {
     @Override
    public boolean supports(Class<?> type) 
    {
       return Paciente.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Paciente paciente = (Paciente)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_Pac", 
        "required.cod_Pac","El campo Codigo Paciente es obligatorio");
    }
}
