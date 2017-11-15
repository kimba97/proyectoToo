
package controladores;

import Sistema.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class BuscarUsuarioController {

    private JdbcTemplate jdbcTemplate; 
    
    public BuscarUsuarioController() {
       
       Conectar con = new Conectar();
       this.jdbcTemplate = new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("buscarUsuario.htm")
    public ModelAndView buscarUsuario()
    { 
        ModelAndView mav = new ModelAndView();
        mav.setViewName("buscarUsuario");
        return mav;
    }
    
    
    
}
