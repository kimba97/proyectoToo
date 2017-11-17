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
public class DoctorController {
    private JdbcTemplate jdbcTemplate; 

    public DoctorController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("doctores.htm")
    public ModelAndView doctores()
    {
        ModelAndView mav = new ModelAndView();
        String sql = "select  d.cod_esp, d.nom_esp, e.cod_emp, p.nombre_p, p.apel_p from doctor d inner join empleado e on d.cod_emp= e.cod_emp inner join persona p on e.dui=p.dui";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("doctores");
        return mav;
    }
    
}

