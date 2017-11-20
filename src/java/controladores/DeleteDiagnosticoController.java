
package controladores;

import Sistema.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class DeleteDiagnosticoController {
    private JdbcTemplate jdbcTemplate;

    public DeleteDiagnosticoController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("deleteDiag.htm")
   public ModelAndView diagnosticos(HttpServletRequest request)
   {
       String cod_diag = (request.getParameter("id"));
       this.jdbcTemplate.update(
       
               "delete from diagnostico "
            + "where "
            +  "cod_diag=? ",
       cod_diag);
       return new ModelAndView("redirect:/diagnosticos.htm");
   }
}
