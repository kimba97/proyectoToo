
package Sistema;


public class Medicamentos {
    private String cod_Med;
    private String cod_Diag;
    private String Nom_Med;
    private String cant_Med;
    private String dosis_Med;
    
    public Medicamentos() {
    }

    public Medicamentos(String cod_Med, String cod_Diag, String Nom_Med, String cant_Med, String dosis_Med) {
        this.cod_Med = cod_Med;
        this.cod_Diag = cod_Diag;
        this.Nom_Med = Nom_Med;
        this.cant_Med = cant_Med;
        this.dosis_Med = dosis_Med;
    }

    

    public String getCod_Med() {
        return cod_Med;
    }

    public void setCod_Med(String cod_Med) {
        this.cod_Med = cod_Med;
    }
    public String getCod_Diag() {
        return cod_Diag;
    }

    public void setCod_Diag(String cod_Diag) {
        this.cod_Diag = cod_Diag;
    }

    public String getNom_Med() {
        return Nom_Med;
    }

    public void setNom_Med(String Nom_Med) {
        this.Nom_Med = Nom_Med;
    }

    public String getCant_Med() {
        return cant_Med;
    }

    public void setCant_Med(String cant_Med) {
        this.cant_Med = cant_Med;
    }

    public String getDosis_Med() {
        return dosis_Med;
    }

    public void setDosis_Med(String dosis_Med) {
        this.dosis_Med = dosis_Med;
    }
    
    
}
