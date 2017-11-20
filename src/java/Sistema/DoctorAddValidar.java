
package Sistema;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class DoctorAddValidar implements Validator{
     @Override
    public boolean supports(Class<?> type) 
    {
       return Doctor.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Doctor doctor = (Doctor)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_Esp", 
        "required.cod_Esp","El campo Codigo de especialidad es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom_Esp", 
        "required.nom_Esp","El campo especialidad es obligatorio");
        
        
    }
}
