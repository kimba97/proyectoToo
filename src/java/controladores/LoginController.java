/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Encriptacion;
import Sistema.Conectar;
import Sistema.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


public class LoginController extends SimpleFormController {
    private JdbcTemplate jdbcTemplate;
    public LoginController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        setCommandClass(Usuario.class);
        setCommandName("login");
        
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) 
            throws Exception {
        Usuario user= (Usuario) command;
        user.setPsw(Encriptacion.Encriptar(user.getPsw()));
        Usuario s= obtenerUsuario(user.getUsuario());
        String m=s.getUsuario();
        String n=s.getPsw();
        ModelAndView mav;
        if(user.getUsuario().equalsIgnoreCase(m) && user.getPsw().equalsIgnoreCase(n)){
            return mav= new ModelAndView("index","user",user);
        }else 
            return mav= new ModelAndView("redirect:/inicio.htm");
    }
    
    public Usuario obtenerUsuario(String username){
        final Usuario m=new Usuario();
        String sql = "SELECT * FROM usuario WHERE username='" +username+"'";
        return (Usuario) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
                m.setUsuario(rs.getString("username"));
                m.setPsw(rs.getString("contrasenia"));
            }
            return m;
        }); 
    }
    
    
}
