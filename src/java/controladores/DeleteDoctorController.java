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
public class DeleteDoctorController {
    private JdbcTemplate jdbcTemplate;
    
    public DeleteDoctorController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("deleteDoctor.htm")
   public ModelAndView doctores(HttpServletRequest request)
   {
       String cod_esp = (request.getParameter("id"));
       this.jdbcTemplate.update(
       
               "delete from doctor "
            + "where "
            +  "cod_esp=? ",
       cod_esp);
       return new ModelAndView("redirect:/doctores.htm");
   }
    
    
}