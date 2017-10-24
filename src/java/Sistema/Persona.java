
package Sistema;

import java.util.Date;

public class Persona {
    private String dui;
    private Clinica clinica;
    private String nombre_P;
    private String apel_P;
    private String sexo_P;
    private Date fecha_Nacim;
    private String Munic_P;
    private String Dep_P;

    public Persona() {
    }

    public Persona(String dui, Clinica clinica, String nombre_P, String apel_P, String sexo_P, Date fecha_Nacim, String Munic_P, String Dep_P) {
        this.dui = dui;
        this.clinica = clinica;
        this.nombre_P = nombre_P;
        this.apel_P = apel_P;
        this.sexo_P = sexo_P;
        this.fecha_Nacim = fecha_Nacim;
        this.Munic_P = Munic_P;
        this.Dep_P = Dep_P;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public String getNombre_P() {
        return nombre_P;
    }

    public void setNombre_P(String nombre_P) {
        this.nombre_P = nombre_P;
    }

    public String getApel_P() {
        return apel_P;
    }

    public void setApel_P(String apel_P) {
        this.apel_P = apel_P;
    }

    public String getSexo_P() {
        return sexo_P;
    }

    public void setSexo_P(String sexo_P) {
        this.sexo_P = sexo_P;
    }

    public Date getFecha_Nacim() {
        return fecha_Nacim;
    }

    public void setFecha_Nacim(Date fecha_Nacim) {
        this.fecha_Nacim = fecha_Nacim;
    }

    public String getMunic_P() {
        return Munic_P;
    }

    public void setMunic_P(String Munic_P) {
        this.Munic_P = Munic_P;
    }

    public String getDep_P() {
        return Dep_P;
    }

    public void setDep_P(String Dep_P) {
        this.Dep_P = Dep_P;
    }
    
    
}
