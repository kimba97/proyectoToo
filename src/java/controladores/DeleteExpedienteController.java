/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Conectar;
import Sistema.Expediente;
import Sistema.Paciente;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kimba
 */
public class DeleteExpedienteController {
    private JdbcTemplate jdbcTemplate;
    
    public DeleteExpedienteController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("deleteExpediente.htm")
   public ModelAndView pacientes(HttpServletRequest request)
   {
       String cod_expe = (request.getParameter("id"));
       this.jdbcTemplate.update(
       
               "delete from expediente "
            + "where "
            +  "cod_expe=? ",
       cod_expe);
       return new ModelAndView("redirect:/expedientes.htm");
   }
    
    
}
