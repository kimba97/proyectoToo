
package Sistema;


public class Usuario {
    private String usuario;
    private String psw;

    public Usuario() {
    }

    public Usuario(String usuario, String psw) {
        this.usuario = usuario;
        this.psw = psw;
    }

   
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
    
    
    
}
