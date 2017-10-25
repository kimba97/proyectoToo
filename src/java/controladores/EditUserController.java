
package controladores;

import Sistema.Conectar;
import Sistema.Usuario;
import Sistema.UsuarioAddValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("editUser.htm")
public class EditUserController {
   
    UsuarioAddValidar usuariosValidar;
    private JdbcTemplate jdbcTemplate;

    public EditUserController() 
    {
        this.usuariosValidar = new UsuarioAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
     @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        String username=(request.getParameter("id"));
        Usuario datos=this.selectUsuario(username);
        mav.setViewName("editUser");
        mav.addObject("usuarios",new Usuario(username, datos.getPsw()));
        return mav;
    }
    
   @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("usuarios") Usuario u,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.usuariosValidar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            String username=(request.getParameter("id"));
            Usuario datos=this.selectUsuario(username);
            mav.setViewName("editUser");
            mav.addObject("usuarios",new Usuario(username, datos.getPsw()));
            return mav;
        }else
        {
            String username=(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "update usuario "
                + "set username=?,"
                + "contrasenia=? "
                + "where "
                + "username=? ",
                
         u.getUsuario(),u.getPsw(),username);
         return new ModelAndView("redirect:/usuarios.htm");
        }
       
    }
    
    public Usuario selectUsuario(String username) 
    {
        final Usuario user = new Usuario();
        String quer = "SELECT * FROM usuario WHERE username='" + username+"'";
        return (Usuario) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<Usuario>() 
            {
                public Usuario extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        
                        user.setUsuario(rs.getString("username"));
                        user.setUsuario(rs.getString("contrasenia"));
                    }
                    return user;
                }


            }
        );
    }
   
    
}
