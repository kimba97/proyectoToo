
package Sistema;

import java.util.ArrayList;


public class Expediente {
  private String codExpe;
  private String paci;
  private String profesion;
  private String estadoCivil;
  private String nomMadre;
  private String nomPadre;
  private String nomConyuge;
  

    public Expediente() {
    }

    public Expediente(String codExpe, String paci, String profesion, String estadoCivil, String nomMadre, String nomPadre, String nomConyuge) {
        this.codExpe = codExpe;
        this.paci = paci;
        this.profesion = profesion;
        this.estadoCivil = estadoCivil;
        this.nomMadre = nomMadre;
        this.nomPadre = nomPadre;
        this.nomConyuge = nomConyuge;
    }

    

    

    public String getPaci() {
        return paci;
    }

    public void setPaci(String paci) {
        this.paci = paci;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    

    public String getCodExpe() {
        return codExpe;
    }

    public void setCodExpe(String codExpe) {
        this.codExpe = codExpe;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNomMadre() {
        return nomMadre;
    }

    public void setNomMadre(String nomMadre) {
        this.nomMadre = nomMadre;
    }

    public String getNomPadre() {
        return nomPadre;
    }

    public void setNomPadre(String nomPadre) {
        this.nomPadre = nomPadre;
    }

    public String getNomConyuge() {
        return nomConyuge;
    }

    public void setNomConyuge(String nomConyuge) {
        this.nomConyuge = nomConyuge;
    }
  
  
}
