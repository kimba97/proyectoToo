/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import Sistema.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 *
 * @author josej
 */
public class MedicamentoController {
    private JdbcTemplate jdbcTemplate; 

    public MedicamentoController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("medicamentos.htm")
    public ModelAndView medicamentos()
    {
        ModelAndView mav = new ModelAndView();
        String sql = "select * from medicamentos";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("medicamentos");
        return mav;
    }
}