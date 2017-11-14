
package Sistema;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class PersonaAddValidar implements Validator{
     @Override
    public boolean supports(Class<?> type) 
    {
       return Persona.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Persona persona = (Persona)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dui", 
        "required.dui","El campo dui es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clinica", 
        "required.clinica","El campo Clinica es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre_P", 
        "required.nombre_P","El campo Nombre es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apel_P", 
        "required.apel_P","El campo Apellidos es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha_Nacim", 
        "required.fecha_Nacim","El campo Fecha de Nacimiento es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Munic_P", 
        "required.Munic_p","El campo Municipio es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Dep_P", 
        "required.Dep_P","El campo Departamento es obligatorio");
    }
}
