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
        String sql = "select e.cod_emp, p.dui, u.username, e.puest_emp, e.salario, c.cod_clin, p.nombre_p, p.apel_p, p.sexo_p, p.fech_nac, p.munic_p, p.dep_p from usuario u inner join empleado e on u.username = e.username inner join persona p on e.dui = p.dui inner join clinica c on p.cod_clin = c.cod_clin";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("empleados");
        return mav;
    }
    
}
