/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author josej
 */
public class EmpleadoController {
    private JdbcTemplate jdbcTemplate; 

    public EmpleadoController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("empleados.htm")
    public ModelAndView empleados()
    {
        ModelAndView mav = new ModelAndView();
        String sql = "select * from empleado";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("empleados");
        return mav;
    }
    
}
