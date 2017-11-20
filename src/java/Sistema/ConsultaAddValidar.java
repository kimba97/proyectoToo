
package Sistema;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class ConsultaAddValidar implements Validator{
    @Override
    public boolean supports(Class<?> type) 
    {
       return Consulta.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Consulta consulta = (Consulta)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_Cons", 
        "required.cod_Cons","El campo Codigo Consulta es obligatorio");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sintom", 
        "required.sintom","El campo Sintomas es obligatorio");
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trat_Med", 
        "required.trat_Med","El campo Tratamiento Medico es obligatorio");
           ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha_Cons", 
        "required.fecha_Cons","El campo Fecha Consulta es obligatorio");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hora_Cons", 
        "required.hora_Cons","El campo Hora Consulta es obligatorio");
             ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doctor_Cons", 
        "required.doctor_Cons","El campo Codigo Doctor es obligatorio");
    }
}
