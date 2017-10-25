
package controladores;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import Sistema.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class DeleteUserController {
   private JdbcTemplate jdbcTemplate; 

    public DeleteUserController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
   
   @RequestMapping("deleteUser.htm")
   public ModelAndView usuarios(HttpServletRequest request)
   {
       String username = (request.getParameter("id"));
       this.jdbcTemplate.update(
       
               "delete from usuario "
            + "where "
            +  "username=? ",
       username);
       return new ModelAndView("redirect:/usuarios.htm");
   }
     
}
