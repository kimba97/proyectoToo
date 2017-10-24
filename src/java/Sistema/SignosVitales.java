
package Sistema;


public class SignosVitales {
    private String temp;
    private double altura;
    private String pres_Cardi;
    private String pres_art;

    public SignosVitales() {
    }

    public SignosVitales(String temp, double altura, String pres_Cardi, String pres_art) {
        this.temp = temp;
        this.altura = altura;
        this.pres_Cardi = pres_Cardi;
        this.pres_art = pres_art;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getPres_Cardi() {
        return pres_Cardi;
    }

    public void setPres_Cardi(String pres_Cardi) {
        this.pres_Cardi = pres_Cardi;
    }

    public String getPres_art() {
        return pres_art;
    }

    public void setPres_art(String pres_art) {
        this.pres_art = pres_art;
    }
    
    
}
