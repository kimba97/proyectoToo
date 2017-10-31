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
public class DeleteEmpleadoController {
    private JdbcTemplate jdbcTemplate; 

    public DeleteEmpleadoController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
   
   @RequestMapping("deleteEmpleado.htm")
   public ModelAndView empleados(HttpServletRequest request)
   {
       String cod_empleado = (request.getParameter("id"));
       this.jdbcTemplate.update(
       
               "delete from empleado "
            + "where "
            +  "cod_emp=? ",
       cod_empleado);
       return new ModelAndView("redirect:/empleados.htm");
   }
}
