
package Sistema;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DiagnosticoAddValidar  implements Validator {
    
     @Override
    public boolean supports(Class<?> type) 
    {
       return Diagnostico.class.isAssignableFrom(type);
    }
    
    @Override
    public void validate(Object o, Errors errors) {
        Diagnostico diagnostico = (Diagnostico)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_Diag", 
        "required.cod_Diag","El campo Codigo de Diagnostico es obligatorio");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrip", 
        "required.descrip","El campo descripcion es obligatorio");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ex", 
        "required.ex","El campo codigo de expediente es obligatorio");
          
    }

}
