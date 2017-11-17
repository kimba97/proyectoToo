/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.util.Date;

/**
 *
 * @author kimba
 */
public class Empleado extends Persona{
    
    private String cod_Emp;
    private String username;
    private double salario;
    private String puest_Emp;
    
    

    public Empleado() {
    }

    public Empleado( String cod_Emp, String username, String puest_Emp, double salario ) {
        this.puest_Emp = puest_Emp;
        this.username = username;
        this.cod_Emp = cod_Emp;
        this.salario = salario;
        
    }

    public Empleado( String cod_Emp, String username, String puest_Emp,double salario,  String dui, String clinica, String nombre_P, String apel_P, String sexo_P, String fecha_Nacim, String Munic_P, String Dep_P) {
        super(dui, clinica, nombre_P, apel_P, sexo_P, fecha_Nacim, Munic_P, Dep_P);
        this.puest_Emp = puest_Emp;
        this.cod_Emp = cod_Emp;
        this.salario = salario;
        this.username = username;
    }
        
   

    

    

    

    public String getUsername() {
        return username;
    }
  
    public void setUsername(String username) {
        this.username = username;
    }
   

    public String getPuest_Emp() {
        return puest_Emp;
    }

    public void setPuest_Emp(String puest_Emp) {
        this.puest_Emp = puest_Emp;
    }

    public String getCod_Emp() {
        return cod_Emp;
    }

    public void setCod_Emp(String cod_Emp) {
        this.cod_Emp = cod_Emp;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String getDui(){
        return super.getDui();
    }
   
    @Override
    public void setDui(String dui){
        super.setDui(dui);
    }
}
