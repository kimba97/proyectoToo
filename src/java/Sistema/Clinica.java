/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

/**
 *
 * @author kimba
 */
//Prueba de actualizacion
public class Clinica {
    private String cod_Clin;
    private String nom_Clin;
    private String Dep_Clin;
    private String Muni_Clin;

    public Clinica() {
    }
//PRUEBA
    public Clinica(String cod_Clin, String nom_Clin, String Dep_Clin, String Muni_Clin) {
        this.cod_Clin = cod_Clin;
        this.nom_Clin = nom_Clin;
        this.Dep_Clin = Dep_Clin;
        this.Muni_Clin = Muni_Clin;
    }

    public String getCod_Clin() {
        return cod_Clin;
    }

    public void setCod_Clin(String cod_Clin) {
        this.cod_Clin = cod_Clin;
    }

    public String getNom_Clin() {
        return nom_Clin;
    }

    public void setNom_Clin(String nom_Clin) {
        this.nom_Clin = nom_Clin;
    }

    public String getDep_Clin() {
        return Dep_Clin;
    }

    public void setDep_Clin(String Dep_Clin) {
        this.Dep_Clin = Dep_Clin;
    }

    public String getMuni_Clin() {
        return Muni_Clin;
    }

    public void setMuni_Clin(String Muni_Clin) {
        this.Muni_Clin = Muni_Clin;
    }
    
    
}
