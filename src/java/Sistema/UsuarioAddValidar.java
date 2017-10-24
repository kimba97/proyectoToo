
package Sistema;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UsuarioAddValidar implements Validator {
    
    @Override
    public boolean supports(Class<?> type) 
    {
       return Usuario.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Usuario usuario = (Usuario)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario", 
        "required.usuario","El campo usuario es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "psw", 
        "required.psw","El campo password es obligatorio");
        
    }
}
