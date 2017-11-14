
package Sistema;


public class Diagnostico {
    private String cod_Diag;
    private String descrip;
    private Expediente ex;
    private Consulta cons;

    public Diagnostico() {
    }

    public Diagnostico(String cod_Diag, String descrip, Expediente ex, Consulta cons) {
        this.cod_Diag = cod_Diag;
        this.descrip = descrip;
        this.ex = ex;
        this.cons = cons;
    }

    

    

    public String getCod_Diag() {
        return cod_Diag;
    }

    public void setCod_Diag(String cod_Diag) {
        this.cod_Diag = cod_Diag;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    
    
    
}
