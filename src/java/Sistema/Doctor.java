
package Sistema;

import java.util.Date;


public class Doctor extends Empleado{
    private String cod_Esp;
    private String nom_Esp;

    public Doctor() {
    }
    

    public Doctor(String cod_Esp, String nom_Esp, String puest_Emp, String cod_Emp, double salario, String user, String dui, Clinica clinica, String nombre_P, String apel_P, String sexo_P, Date fecha_Nacim, String Munic_P, String Dep_P) {
        super(puest_Emp, cod_Emp, salario, user, dui, clinica, nombre_P, apel_P, sexo_P, fecha_Nacim, Munic_P, Dep_P);
        this.cod_Esp = cod_Esp;
        this.nom_Esp = nom_Esp;
    }

    

    public String getCod_Esp() {
        return cod_Esp;
    }

    public void setCod_Esp(String cod_Esp) {
        this.cod_Esp = cod_Esp;
    }

    public String getNom_Esp() {
        return nom_Esp;
    }

    public void setNom_Esp(String nom_Esp) {
        this.nom_Esp = nom_Esp;
    }
    
    
    
}
