/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author kimba
 */
public class Consulta {
    private String cod_Cons;
    private String sintom;
    private String trat_Med;
    private Date fecha_Cons;
    private String hora_Cons;
    private String doctor_Cons;
    private String CodSign;

    public Consulta() {
    }

    public Consulta(String cod_Cons, String sintom, String trat_Med, Date fecha_Cons, String hora_Cons, String doctor_Cons, String CodSign) {
        this.cod_Cons = cod_Cons;
        this.sintom = sintom;
        this.trat_Med = trat_Med;
        this.fecha_Cons = fecha_Cons;
        this.hora_Cons = hora_Cons;
        this.doctor_Cons = doctor_Cons;
        this.CodSign = CodSign;
    }

    

    

    
    public String getCod_Cons() {
        return cod_Cons;
    }

    public void setCod_Cons(String cod_Cons) {
        this.cod_Cons = cod_Cons;
    }

    public String getSintom() {
        return sintom;
    }

    public void setSintom(String sintom) {
        this.sintom = sintom;
    }

    public String getTrat_Med() {
        return trat_Med;
    }

    public void setTrat_Med(String trat_Med) {
        this.trat_Med = trat_Med;
    }

    public Date getFecha_Cons() {
        return fecha_Cons;
    }

    public void setFecha_Cons(Date fecha_Cons) {
        this.fecha_Cons = fecha_Cons;
    }

    public String getHora_Cons() {
        return hora_Cons;
    }

    public void setHora_Cons(String hora_Cons) {
        this.hora_Cons = hora_Cons;
    }

    public String getDoctor_Cons() {
        return doctor_Cons;
    }

    public void setDoctor_Cons(String doctor_Cons) {
        this.doctor_Cons = doctor_Cons;
    }

    public String getCodSign() {
        return CodSign;
    }

    public void setCodSign(String CodSign) {
        this.CodSign = CodSign;
    }

    

    
    
}
