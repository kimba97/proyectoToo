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
public class DeleteMedicamentoController {
    private JdbcTemplate jdbcTemplate; 

    public DeleteMedicamentoController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
   
   @RequestMapping("deleteMedicamento.htm")
   public ModelAndView medicamentos(HttpServletRequest request)
   {
       String cod_med = (request.getParameter("id"));
       this.jdbcTemplate.update(
       
               "delete from medicamentos "
            + "where "
            +  "cod_med=? ",
       cod_med);
       return new ModelAndView("redirect:/medicamentos.htm");
   }
}
