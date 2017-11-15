
package controladores;

import Sistema.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public class ExpedienteDatosController {
   
    private JdbcTemplate jdbcTemplate; 

    public ExpedienteDatosController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("expedienteDatos.htm")
    public ModelAndView ExpedienteDatos()
    {
        ModelAndView mav = new ModelAndView();
        //String sql = "select * from usuario";
       // List datos = this.jdbcTemplate.queryForList(sql);
       // mav.addObject("datos",datos);
        mav.setViewName("expedienteDatos");
        return mav;
    }
    
}
