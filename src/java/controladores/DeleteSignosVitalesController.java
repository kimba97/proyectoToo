
package controladores;

import Sistema.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class DeleteSignosVitalesController {
    private JdbcTemplate jdbcTemplate;

    public DeleteSignosVitalesController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("deleteSignos.htm")
   public ModelAndView signos(HttpServletRequest request)
   {
       int username = Integer.valueOf((request.getParameter("id")));
       this.jdbcTemplate.update(
       
               "delete from signos_vitales "
            + "where "
            +  "cod_sin=? ",
       username);
       return new ModelAndView("redirect:/signosVitales.htm");
   }
    
}
