package Sistema;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignosVitalesAddValidar implements Validator {
    
    @Override
   
     public boolean supports(Class<?> type) 
    {
       return SignosVitales.class.isAssignableFrom(type);
    }
    
     @Override
        public void validate(Object o, Errors errors) {
        SignosVitales signVi = (SignosVitales)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "temp", 
        "required.temp","El campo Temperatura es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "altura", 
        "required.altura","El campo Altura es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pres_Cardi", 
        "required.pres_Cardi","El campo Presion Cardiaca es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pres_art", 
        "required.pres_art","El campo Presion Arterial es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Paciente", 
        "required.Paciente","El campo Codigo de Paciente es obligatorio");
       
    }
    
}
