
package controladores;

import Sistema.Conectar;
import Sistema.Empleado;
import Sistema.Encriptacion;
import Sistema.Usuario;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
    private JdbcTemplate jdbcTemplate;
    
    public LoginController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Digite sus datos para ingresar");
        return "inicio";
    }
    
     @RequestMapping(method = RequestMethod.POST)
    public String submit(HttpServletRequest request, HttpServletResponse response,Model model, @ModelAttribute("Usuario") Usuario loginBean) throws ServletException, IOException {
        
        if ( loginBean.getUsuario().length()!= 0 && loginBean.getPsw().length()!= 0) {
            
            Usuario u = obtenerUsuario(loginBean.getUsuario());
            Empleado e = obtenerPuesto(loginBean.getUsuario());
            
            if (loginBean.getUsuario().equals(u.getUsuario()) && loginBean.getPsw().equals(u.getPsw())) {
                //agregado por Luis para las cookiesession
                doGet(request , response , e.getPuest_Emp());
                
                if (e.getPuest_Emp().equalsIgnoreCase("Doctor")) {
                    return "vistaMedico";
                 } else if (e.getPuest_Emp().equalsIgnoreCase("Fisioterapista")){
                 return "vistaFisioterapista";
               }
                
            } 
            
            else {
                model.addAttribute("error", "Datos invalidos, intente nuevamente");
                return "inicio";
            }
        
        } else {
            model.addAttribute("error", "Por favor complete los campos");
            return "inicio";
        }
        return null;
    }
    
    public Usuario obtenerUsuario(String username){
        final Usuario m=new Usuario();
        String sql = "SELECT * FROM usuario WHERE username='" +username+"'";
        return (Usuario) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
                m.setUsuario(rs.getString("username"));
                try {
                    m.setPsw(Encriptacion.Desencriptar(rs.getString("contrasenia")));
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return m;
        }); 
    }
    
    //Metodo para obtener el puesto  del empleado
    public Empleado obtenerPuesto(String username){
        final Empleado e=new Empleado();
        String sql = "SELECT * FROM empleado WHERE username='" +username+"'";
        return (Empleado) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
               e.setCod_Emp(rs.getString("cod_emp"));
               e.setPuest_Emp(rs.getString("puest_emp"));
            }
            return e;
        }); 
    }
    
    
    //agregado por Luis para las cookiesession
    //AQUI SE CREA LA COOKIE
    /**
     *
     * @param request
     * @param response
     * @param username
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response, String puesto) throws ServletException, IOException {
        //conseguir input values
        String Puesto = puesto;

        //make cookies and store new data in cookies
        Cookie sessionCookie = new Cookie("sessionCookie", Puesto);
        sessionCookie.setMaxAge(60*60*24*2);
        sessionCookie.setPath("/");
        response.addCookie(sessionCookie);
    }
    
}
