
package Sistema;


public class Examenes {
    private String cod_Ex;
    private boolean orina;
    private boolean quim_Sang;
    private boolean radio;
    private boolean ultra;
    private boolean electro;
    private boolean otros;

    public Examenes() {
    }

    public Examenes(String cod_Ex, boolean orina, boolean quim_Sang, boolean radio, boolean ultra, boolean electro, boolean otros) {
        this.cod_Ex = cod_Ex;
        this.orina = orina;
        this.quim_Sang = quim_Sang;
        this.radio = radio;
        this.ultra = ultra;
        this.electro = electro;
        this.otros = otros;
    }

    public String getCod_Ex() {
        return cod_Ex;
    }

    public void setCod_Ex(String cod_Ex) {
        this.cod_Ex = cod_Ex;
    }

    public boolean isOrina() {
        return orina;
    }

    public void setOrina(boolean orina) {
        this.orina = orina;
    }

    public boolean isQuim_Sang() {
        return quim_Sang;
    }

    public void setQuim_Sang(boolean quim_Sang) {
        this.quim_Sang = quim_Sang;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public boolean isUltra() {
        return ultra;
    }

    public void setUltra(boolean ultra) {
        this.ultra = ultra;
    }

    public boolean isElectro() {
        return electro;
    }

    public void setElectro(boolean electro) {
        this.electro = electro;
    }

    public boolean isOtros() {
        return otros;
    }

    public void setOtros(boolean otros) {
        this.otros = otros;
    }
    
    
}
