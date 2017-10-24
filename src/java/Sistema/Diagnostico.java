
package Sistema;


public class Diagnostico {
    private String cod_Diag;
    private String descrip;
    private Medicamentos medicina_recetada;
    private Examenes exam_Paciente;

    public Diagnostico() {
    }

    public Diagnostico(String cod_Diag, String descrip, Medicamentos medicina_recetada, Examenes exam_Paciente) {
        this.cod_Diag = cod_Diag;
        this.descrip = descrip;
        this.medicina_recetada = medicina_recetada;
        this.exam_Paciente = exam_Paciente;
    }

    public Examenes getExam_Paciente() {
        return exam_Paciente;
    }

    public void setExam_Paciente(Examenes exam_Paciente) {
        this.exam_Paciente = exam_Paciente;
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

    public Medicamentos getMedicina_recetada() {
        return medicina_recetada;
    }

    public void setMedicina_recetada(Medicamentos medicina_recetada) {
        this.medicina_recetada = medicina_recetada;
    }
    
    
}
