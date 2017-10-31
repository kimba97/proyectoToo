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
 * @author josej
 */
public class DeleteClinicaController {
    private JdbcTemplate jdbcTemplate; 

    public DeleteClinicaController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
   
   @RequestMapping("deleteClinica.htm")
   public ModelAndView clinicas(HttpServletRequest request)
   {
       String cod_clinica = (request.getParameter("id"));
       this.jdbcTemplate.update(
       
               "delete from clinica "
            + "where "
            +  "cod_clin=? ",
       cod_clinica);
       return new ModelAndView("redirect:/clinicas.htm");
   }
}
