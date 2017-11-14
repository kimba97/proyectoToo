
package Sistema;

import java.util.Date;


public class Paciente extends Persona{
    private String cod_Pac;
   
    public Paciente() {
    }

    public Paciente(String cod_Pac) {
        this.cod_Pac = cod_Pac;
    }

    public Paciente(String cod_Pac, String dui, String clinica, String nombre_P, String apel_P, String sexo_P, String fecha_Nacim, String Munic_P, String Dep_P) {
        super(dui, clinica, nombre_P, apel_P, sexo_P, fecha_Nacim, Munic_P, Dep_P);
        this.cod_Pac = cod_Pac;
    }

   



    

    public String getCod_Pac() {
        return cod_Pac;
    }

    public void setCod_Pac(String cod_Pac) {
        this.cod_Pac = cod_Pac;
    }
        
}
