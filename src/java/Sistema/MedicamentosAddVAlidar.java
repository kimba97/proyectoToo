
package Sistema;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MedicamentosAddVAlidar  implements Validator {
      @Override
    public boolean supports(Class<?> type) 
    {
       return Medicamentos.class.isAssignableFrom(type);
     }
    
     @Override
    public void validate(Object o, Errors errors) {
        Medicamentos medicamento = (Medicamentos)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_Med", 
        "required.cod_Med","El campo Codigo de Medicamento es obligatorio");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nom_Med", 
        "required.Nom_Med","El campo Nombre de Medicamento es obligatorio");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cant_Med", 
        "required.cant_Med","El campo Cantidad del Medicamento es obligatorio");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dosis_Med", 
        "required.dosis_Med","El campo Dosis Medica es obligatorio");
          
    }
}
