
package Sistema;

import java.util.Date;


public class Paciente extends Persona{
    private String cod_Pac;
    private String profesi_Pac;
    private String estado_Civ;
    private String nom_Res;
    private SignosVitales signos;

    public Paciente() {
    }

    public Paciente(String cod_Pac, String profesi_Pac, String estado_Civ, String nom_Res, SignosVitales signos, String dui, Clinica clinica, String nombre_P, String apel_P, String sexo_P, Date fecha_Nacim, String Munic_P, String Dep_P) {
        super(dui, clinica, nombre_P, apel_P, sexo_P, fecha_Nacim, Munic_P, Dep_P);
        this.cod_Pac = cod_Pac;
        this.profesi_Pac = profesi_Pac;
        this.estado_Civ = estado_Civ;
        this.nom_Res = nom_Res;
        this.signos = signos;
    }

    public String getCod_Pac() {
        return cod_Pac;
    }

    public void setCod_Pac(String cod_Pac) {
        this.cod_Pac = cod_Pac;
    }

    public String getProfesi_Pac() {
        return profesi_Pac;
    }

    public void setProfesi_Pac(String profesi_Pac) {
        this.profesi_Pac = profesi_Pac;
    }

    public String getEstado_Civ() {
        return estado_Civ;
    }

    public void setEstado_Civ(String estado_Civ) {
        this.estado_Civ = estado_Civ;
    }

    public String getNom_Res() {
        return nom_Res;
    }

    public void setNom_Res(String nom_Res) {
        this.nom_Res = nom_Res;
    }

    public SignosVitales getSignos() {
        return signos;
    }

    public void setSignos(SignosVitales signos) {
        this.signos = signos;
    }
    
    
}
