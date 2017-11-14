
package Sistema;


public class Examenes {
    private String cod_Ex;
    private String CodExped;
    private byte archivo;
    private String descExam;

    public Examenes() {
    }

    public Examenes(String cod_Ex, String CodExped, byte archivo, String descExam) {
        this.cod_Ex = cod_Ex;
        this.CodExped = CodExped;
        this.archivo = archivo;
        this.descExam = descExam;
    }

    

    public String getCod_Ex() {
        return cod_Ex;
    }

    public void setCod_Ex(String cod_Ex) {
        this.cod_Ex = cod_Ex;
    }

    public String getCodExped() {
        return CodExped;
    }

    public void setCodExped(String exped) {
        this.CodExped = exped;
    }

    public byte getArchivo() {
        return archivo;
    }

    public void setArchivo(byte archivo) {
        this.archivo = archivo;
    }

    public String getDescExam() {
        return descExam;
    }

    public void setDescExam(String descExam) {
        this.descExam = descExam;
    }
    
    
    
    
}
