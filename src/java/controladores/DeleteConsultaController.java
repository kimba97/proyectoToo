/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author kimba
 */
public class DeleteConsultaController {
    private JdbcTemplate jdbcTemplate;

    public DeleteConsultaController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("deleteConsulta.htm")
   public ModelAndView consultas(HttpServletRequest request)
   {
       String cod_cons = (request.getParameter("id"));
       this.jdbcTemplate.update(
       
               "delete from consulta "
            + "where "
            +  "cod_cons=? ",
       cod_cons);
       return new ModelAndView("redirect:/consultas.htm");
   }
    
}
