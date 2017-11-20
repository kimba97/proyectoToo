
package Sistema;


public class Diagnostico {
    private String cod_Diag;
    private String descrip;
    private String ex;
    private String cons;

    public Diagnostico() {
    }

    public Diagnostico(String cod_Diag, String descrip, String ex, String cons) {
        this.cod_Diag = cod_Diag;
        this.descrip = descrip;
        this.ex = ex;
        this.cons = cons;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
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
