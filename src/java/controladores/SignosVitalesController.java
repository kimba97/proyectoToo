
package controladores;

import Sistema.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class SignosVitalesController {

     private JdbcTemplate jdbcTemplate; 

    public SignosVitalesController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
 
    @RequestMapping("signosVitales.htm")
    public ModelAndView usuarios()
    {
        ModelAndView mav = new ModelAndView();
        String sql = "select * from signos_vitales";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("signosVitales");
        return mav;
    }
}
